package w4yuan;

public class FieldIR {

	private FieldType fieldType;

	// 仅当 FieldType=ARRAY 是才有效
	private FieldType subFieldType;

	private String fieldName;

	// 仅当 FiledType=OBJECT 生效
	private String className;

	private String defaultValue;

	// 是否使用原生 java 类型
	// 数组和 String 比原生 java 会慢很多，因为涉及到内存拷贝
	private boolean origin = false;

	private int order;

	public FieldType getFieldType() {
		return fieldType;
	}

	public void setFieldType(FieldType fieldType) {
		this.fieldType = fieldType;
	}

	public FieldType getSubFieldType() {
		return subFieldType;
	}

	public void setSubFieldType(FieldType subFieldType) {
		this.subFieldType = subFieldType;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getMethodFieldName() {
		char c = this.fieldName.charAt(0);
		char upperCase = Character.toUpperCase(c);
		return this.fieldName.replaceFirst(String.valueOf(c), String.valueOf(upperCase));
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public boolean isOrigin() {
		return origin;
	}

	public void setOrigin(boolean origin) {
		this.origin = origin;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public boolean hasDefaultValue() {
		return defaultValue != null;
	}

	public void setDefaultValue(String defaultValue) {
		if (defaultValue == null) {
			return;
		}
		try {
			String temp;
			switch (this.fieldType) {
				case INT:
					Integer.parseInt(defaultValue);
					break;
				case DOUBLE:
					temp = String.valueOf(Double.parseDouble(defaultValue));
					if (!temp.equals(defaultValue)) {
						throw new IllegalArgumentException("Double default value exceeds accuracy.");
					}
					break;
				case FLOAT:
					temp = String.valueOf(Float.parseFloat(defaultValue));
					if (!temp.equals(defaultValue)) {
						throw new IllegalArgumentException("Float default value exceeds accuracy.");
					}
					break;
				case BYTE:
					Byte.parseByte(defaultValue);
					break;
				case LONG:
					Long.parseLong(defaultValue);
					break;
				case CHAR:
					if (defaultValue.length() != 1) {
						throw new IllegalArgumentException("Char default value config error.");
					}
					break;
				case BOOLEAN:
					Boolean.parseBoolean(defaultValue);
					break;
				default:
					break;
			}
		} catch (Exception e) {
			throw new TerminationException("Order " + this.order + " default value config error.", e);
		}
		this.defaultValue = defaultValue;
	}
}
