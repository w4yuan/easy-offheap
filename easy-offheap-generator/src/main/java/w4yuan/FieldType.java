package w4yuan;

public enum FieldType {
	LONG(8, "long", "Long"), INT(4, "int", "Int"), BOOLEAN(1, "boolean", "Boolean"), BYTE(1, "byte", "Byte"), CHAR(2,
			"char", "Char"), STRING(8, "string", ""), FLOAT(4, "float", "Float"), DOUBLE(8, "double", "Double"),

	// 后续支持的字段
	ARRAY(8, "", ""), CLASS(8, "", "");

	private final int bytes;

	private final String name;

	private final String suffix;

	FieldType(int bytes, String name, String suffix) {
		this.bytes = bytes;
		this.name = name;
		this.suffix = suffix;
	}

	public int getBytes() {
		return bytes;
	}

	public String getName() {
		return name;
	}

	public String getSuffix() {
		return suffix;
	}

	public boolean isPrimitive() {
		return this == LONG || this == BYTE || this == INT || this == FLOAT || this == DOUBLE || this == CHAR
				|| this == BOOLEAN;
	}

	public boolean isString() {
		return this == STRING;
	}

	public boolean isArray() {
		return this == ARRAY;
	}

	public boolean isObject() {
		return this == CLASS || this == ARRAY || this == STRING;
	}

	public boolean isClass() {
		return this == CLASS;
	}

	public boolean isChar() {
		return this == CHAR;
	}

	public boolean isFloat() {
		return this == FLOAT;
	}
}
