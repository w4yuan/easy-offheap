package w4yuan.offheap;


import w4yuan.CleanTask;
import w4yuan.CustomCleaner;
import w4yuan.ReferenceUtils;
import w4yuan.UnsafeMemoryManager;

public abstract class OffHeapObject<T> {

	protected long address;

	protected final int totalBytes;

	private CustomCleaner cleaner;

	public OffHeapObject(T t) {
		byte[] bytes = convertToBytes(t);
		this.address = UnsafeMemoryManager.allocateMemory(bytes);
		this.totalBytes = bytes.length;
		cleaner = ReferenceUtils.create(this, new CleanTask(this.address, this.totalBytes));
	}

	public T getObject() {
		if (this.address == 0L) {
			return null;
		}
		byte[] bytes = UnsafeMemoryManager.getObject(address, totalBytes);
		return convertToObject(bytes);
	}

	public int getTotalBytes(){
		return this.totalBytes;
	}

	protected abstract T convertToObject(byte[] bytes);

	protected abstract byte[] convertToBytes(T t);

}
