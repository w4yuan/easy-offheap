package w4yuan.offheap;


import w4yuan.NumberUtils;
import w4yuan.UnsafeMemoryManager;

public class OffHeapCharArray extends OffHeapObject<char[]> {

	public OffHeapCharArray(char[] chars) {
		super(chars);
	}

	@Override
	protected char[] convertToObject(byte[] bytes) {
		int length = bytes.length;
		char[] ret = new char[length >> 1];
		int index = 0;
		for (int i = 0; i < length; i += 2) {
			ret[index++] = NumberUtils.bytesToChar(bytes, i);
		}
		return ret;
	}

	@Override
	protected byte[] convertToBytes(char[] chars) {
		byte[] ret = new byte[chars.length << 1];
		int index = 0;
		for (char c : chars) {
			NumberUtils.charToBytes(ret, index, c);
			index += 2;
		}
		return ret;
	}

	public int getLength() {
		return totalBytes >> 1;
	}

	public char get(int index) {
		if (index >= getLength()) {
			throw new IllegalArgumentException("index out of bound.");
		}
		byte[] data = UnsafeMemoryManager.getObject(address + ((long) index << 1), 2);
		return NumberUtils.bytesToChar(data, 0);
	}
}
