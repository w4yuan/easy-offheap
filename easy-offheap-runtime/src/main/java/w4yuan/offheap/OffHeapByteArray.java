package w4yuan.offheap;


import w4yuan.UnsafeMemoryManager;

public class OffHeapByteArray extends OffHeapObject<byte[]> {
	public OffHeapByteArray(byte[] bytes) {
		super(bytes);
	}

	@Override
	protected byte[] convertToObject(byte[] bytes) {
		return bytes;
	}

	@Override
	protected byte[] convertToBytes(byte[] bytes) {
		return bytes;
	}

	public int getLength() {
		return totalBytes;
	}

	public byte get(int index) {
		if (index >= getLength()) {
			throw new IllegalArgumentException("index out of bound.");
		}
		return UnsafeMemoryManager.getByte(address + index);
	}
}
