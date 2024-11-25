package w4yuan;

// 统一使用大端储存
public class NumberUtils {

	public static void longToBytes(byte[] array, int startIndex, long value) {
		for (int i = 0; i < 8; i++) {
			array[startIndex++] = (byte) (value >> (56 - i * 8));
		}
	}

	public static long bytesToLong(byte[] array, int startIndex) {
		long value = 0;
		for (int i = 0; i < 8; i++) {
			value += ((long) array[startIndex++] & 255) << (56 - i * 8);
		}
		return value;
	}

	public static void intToBytes(byte[] array, int startIndex, int value) {
		for (int i = 0; i < 4; i++) {
			array[startIndex++] = (byte) (value >> (24 - i * 8));
		}
	}

	public static int bytesToInt(byte[] array, int startIndex) {
		int value = 0;
		for (int i = 0; i < 4; i++) {
			value += ((int) array[startIndex++] & 255) << (24 - i * 8);
		}
		return value;
	}

	public static void charToBytes(byte[] array, int startIndex, char value) {
		for (int i = 0; i < 2; i++) {
			array[startIndex++] = (byte) (value >> (8 - i * 8));
		}
	}

	public static char bytesToChar(byte[] array, int startIndex) {
		char value = 0;
		for (int i = 0; i < 2; i++) {
			value += ((char) array[startIndex++] & 255) << (8 - i * 8);
		}
		return value;
	}

}
