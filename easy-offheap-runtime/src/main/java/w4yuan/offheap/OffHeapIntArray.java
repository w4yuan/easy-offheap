package w4yuan.offheap;


import w4yuan.NumberUtils;
import w4yuan.UnsafeMemoryManager;

public class OffHeapIntArray extends OffHeapObject<int[]> {
	public OffHeapIntArray(int[] ints) {
		super(ints);
	}

	@Override
	protected int[] convertToObject(byte[] bytes) {
		int length = bytes.length;
		int[] ret = new int[length >> 2];
		int index = 0;
		for (int i = 0; i < length; i += 4) {
			ret[index++] = NumberUtils.bytesToInt(bytes, i);
		}
		return ret;
	}

	@Override
	protected byte[] convertToBytes(int[] ints) {
		int length = ints.length;
		byte[] ret = new byte[length << 2];
		int index = 0;
		for (int l : ints) {
			NumberUtils.intToBytes(ret, index, l);
			index += 4;
		}
		return ret;
	}

	public int getLength() {
		return totalBytes >> 2;
	}

	public int get(int index) {
		if (index >= getLength()) {
			throw new IllegalArgumentException("index out of bound.");
		}
		byte[] data = UnsafeMemoryManager.getObject(address + ((long) index << 2), 4);
		return NumberUtils.bytesToInt(data, 0);
	}
}
