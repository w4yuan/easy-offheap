package w4yuan;

import java.util.List;

public class ClassIR {

	private String className;

	private int totalBytes;

	private String packageName;

	private List<FieldIR> fieldIRList;

	private String fieldStr;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getTotalBytes() {
		return totalBytes;
	}

	public void setTotalBytes(int totalBytes) {
		this.totalBytes = totalBytes;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public List<FieldIR> getFieldIRList() {
		return fieldIRList;
	}

	public void setFieldIRList(List<FieldIR> fieldIRList) {
		this.fieldIRList = fieldIRList;
	}

	public String getFieldStr() {
		return fieldStr;
	}

	public void setFieldStr(String fieldStr) {
		this.fieldStr = fieldStr;
	}

}
