package w4yuan;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicLong;

public class UnsafeMemoryManager {

	static Unsafe unsafe;

	static {
		try {
			Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
			theUnsafe.setAccessible(true);
			unsafe = (Unsafe) theUnsafe.get(null);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			throw new RuntimeException("unsafe fetch fail");
		}
	}

	private static final AtomicLong totalUsedBytes = new AtomicLong(0L);

	private UnsafeMemoryManager() {

	}

	public static long allocateMemory(int totalBytes) {
		long address = unsafe.allocateMemory(totalBytes);
		unsafe.setMemory(address, totalBytes, (byte) 0);
		totalUsedBytes.getAndAdd(totalBytes);
		return address;
	}

	public static long allocateMemory(byte[] bytes) {
		int totalBytes = bytes.length;
		long address = unsafe.allocateMemory(totalBytes);
		unsafe.copyMemory(bytes, Unsafe.ARRAY_BYTE_BASE_OFFSET, null, address, bytes.length);
		totalUsedBytes.getAndAdd(totalBytes);
		return address;
	}

	public static void releaseMemory(long address, int totalBytes) {
		unsafe.freeMemory(address);
		totalUsedBytes.getAndAdd(-totalBytes);
	}

	public static void putLong(long address, long value) {
		unsafe.putLong(address, value);
	}

	public static long getLong(long address) {
		return unsafe.getLong(address);
	}

	public static void putInt(long address, int value) {
		unsafe.putInt(address, value);
	}

	public static int getInt(long address) {
		return unsafe.getInt(address);
	}

	public static void putShort(long address, short value) {
		unsafe.putShort(address, value);
	}

	public static short getShort(long address) {
		return unsafe.getShort(address);
	}

	public static void putByte(long address, byte value) {
		unsafe.putByte(address, value);
	}

	public static byte getByte(long address) {
		return unsafe.getByte(address);
	}

	public static void putFloat(long address, float value) {
		unsafe.putFloat(address, value);
	}

	public static float getFloat(long address) {
		return unsafe.getFloat(address);
	}

	public static void putDouble(long address, double value) {
		unsafe.putDouble(address, value);
	}

	public static double getDouble(long address) {
		return unsafe.getDouble(address);
	}

	public static byte[] getObject(long address, int length) {
		byte[] copy = new byte[length];
		unsafe.copyMemory(null, address, copy, Unsafe.ARRAY_BYTE_BASE_OFFSET, length);
		return copy;
	}

	public static void putChar(long address, char value) {
		unsafe.putChar(address, value);
	}

	public static char getChar(long address) {
		return unsafe.getChar(address);
	}

	public static void putBoolean(long address, boolean value) {
		unsafe.putBoolean(null, address, value);
	}

	public static boolean getBoolean(long address) {
		return unsafe.getBoolean(null, address);
	}

	public static Unsafe getUnsafe() {
		return unsafe;
	}

	public static long getTotalUsedBytes() {
		return totalUsedBytes.get();
	}

}
