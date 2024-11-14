package w4yuan.offheap;


import w4yuan.NumberUtils;
import w4yuan.UnsafeMemoryManager;

public class OffHeapDoubleArray extends OffHeapObject<double[]> {
	
	public OffHeapDoubleArray(double[] doubles) {
		super(doubles);
	}

	@Override
	protected double[] convertToObject(byte[] bytes) {
		double[] ret = new double[bytes.length >> 3];
		int index = 0;
		for (int i = 0; i < bytes.length; i += 8) {
			long d = NumberUtils.bytesToLong(bytes, i);
			ret[index++] = Double.longBitsToDouble(d);
		}
		return ret;
	}

	@Override
	protected byte[] convertToBytes(double[] doubles) {
		byte[] ret = new byte[doubles.length << 3];
		int index = 0;
		for (double d : doubles) {
			long l = Double.doubleToLongBits(d);
			NumberUtils.longToBytes(ret, index, l);
			index += 8;
		}
		return ret;
	}

	public int getLength() {
		return totalBytes >> 3;
	}

	public double get(int index) {
		if (index >= getLength()) {
			throw new IllegalArgumentException("index out of bound.");
		}
		byte[] data = UnsafeMemoryManager.getObject(address + ((long) index << 3), 8);
		return Double.longBitsToDouble(NumberUtils.bytesToLong(data, 0));
	}
}
