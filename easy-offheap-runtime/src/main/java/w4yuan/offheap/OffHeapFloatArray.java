package w4yuan.offheap;


import w4yuan.NumberUtils;
import w4yuan.UnsafeMemoryManager;

public class OffHeapFloatArray extends OffHeapObject<float[]> {

	public OffHeapFloatArray(float[] floats) {
		super(floats);
	}

	@Override
	protected float[] convertToObject(byte[] bytes) {
		float[] ret = new float[bytes.length >> 2];
		int index = 0;
		for (int i = 0; i < bytes.length; i += 4) {
			int f = NumberUtils.bytesToInt(bytes, i);
			ret[index++] = Float.intBitsToFloat(f);
		}
		return ret;
	}

	@Override
	protected byte[] convertToBytes(float[] floats) {
		byte[] ret = new byte[floats.length << 2];
		int index = 0;
		for (float f : floats) {
			int i = Float.floatToIntBits(f);
			NumberUtils.intToBytes(ret, index, i);
			index += 4;
		}
		return ret;
	}

	public int getLength() {
		return totalBytes >> 2;
	}

	public float get(int index) {
		if (index >= getLength()) {
			throw new IllegalArgumentException("index out of bound.");
		}
		byte[] data = UnsafeMemoryManager.getObject(address + ((long) index << 2), 4);
		return Float.intBitsToFloat(NumberUtils.bytesToInt(data, 0));
	}
}
