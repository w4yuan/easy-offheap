package w4yuan.offheap;

public class OffHeapString extends OffHeapObject<String> {


	public OffHeapString(String s) {
		super(s);
	}

	@Override
	protected String convertToObject(byte[] bytes) {
		return new String(bytes);
	}

	@Override
	protected byte[] convertToBytes(String s) {
		return s.getBytes();
	}

	public int getLength() {
		return this.totalBytes >> 1;
	}
}
