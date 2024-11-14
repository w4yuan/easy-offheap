package w4yuan.offheap;


import w4yuan.UnsafeMemoryManager;

public class OffHeapBooleanArray extends OffHeapObject<boolean[]> {
	public OffHeapBooleanArray(boolean[] booleans) {
		super(booleans);
	}

	public int getLength() {
		return totalBytes;
	}

	public boolean get(int index) {
		if (index >= getLength()) {
			throw new IllegalArgumentException("index out of bound.");
		}
		return UnsafeMemoryManager.getByte(address + index) > 0;
	}

	@Override
	protected boolean[] convertToObject(byte[] bytes) {
		boolean[] ret = new boolean[bytes.length];
		for (int i = 0; i < bytes.length; i++) {
			ret[i] = bytes[i] > 0;
		}
		return ret;
	}

	@Override
	protected byte[] convertToBytes(boolean[] booleans) {
		byte[] ret = new byte[booleans.length];
		for (int i = 0; i < booleans.length; i++) {
			ret[i] = booleans[i] ? (byte) 1 : (byte) 0;
		}
		return ret;
	}
}
