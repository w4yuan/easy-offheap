package w4yuan;

public class CleanTask implements Runnable {
	
	private long address;

	private final int totalBytes;

	public CleanTask(long address, int totalBytes) {
		this.address = address;
		this.totalBytes = totalBytes;
	}

	@Override
	public void run() {
		if (address == 0) {
			return;
		}
		UnsafeMemoryManager.releaseMemory(address, totalBytes);
		address = 0;
	}

}
