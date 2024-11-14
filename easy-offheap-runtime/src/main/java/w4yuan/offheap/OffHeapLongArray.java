package w4yuan.offheap;


import w4yuan.NumberUtils;
import w4yuan.UnsafeMemoryManager;

public class OffHeapLongArray extends OffHeapObject<long[]> {

	public OffHeapLongArray(long[] longs) {
		super(longs);
	}

	@Override
	protected long[] convertToObject(byte[] bytes) {
		int length = bytes.length;
		long[] ret = new long[length >> 3];
		int index = 0;
		for (int i = 0; i < length; i += 8) {
			ret[index++] = NumberUtils.bytesToLong(bytes, i);
		}
		return ret;
	}

	@Override
	protected byte[] convertToBytes(long[] longs) {
		int length = longs.length;
		byte[] ret = new byte[length << 3];
		int index = 0;
		for (long l : longs) {
			NumberUtils.longToBytes(ret, index, l);
			index += 8;
		}
		return ret;
	}

	public int getLength() {
		return totalBytes >> 3;
	}

	public long get(int index) {
		if (index >= getLength()) {
			throw new IllegalArgumentException("index out of bound.");
		}
		byte[] data = UnsafeMemoryManager.getObject(address + ((long) index << 3), 8);
		return NumberUtils.bytesToLong(data, 0);
	}
}
