<#if (classIR.packageName)??>
package ${classIR.packageName};
</#if>
import w4yuan.offheap.*;
import w4yuan.*;

public class ${classIR.className} {

    <#if classIR.totalBytes != 0>
    public static final int TOTAL_BYTES = ${classIR.totalBytes};
    </#if>

${classIR.fieldStr}

    <#if classIR.totalBytes != 0>
    public final long address;

    private CustomCleaner cleaner;
    </#if>
    <#if classIR.totalBytes == 0>
    public ${classIR.className}() {
    }
    <#else>
    public ${classIR.className}() {
        address = UnsafeMemoryManager.allocateMemory(TOTAL_BYTES);
        cleaner = ReferenceUtils.create(this, new CleanTask(address, TOTAL_BYTES));
        <#list classIR.fieldIRList as field>
        <#if field.hasDefaultValue()>
        set${field.getMethodFieldName()}(${field.fieldName}_DEFAULT);
        </#if>
        </#list>
    }
    </#if>
	<#list classIR.fieldIRList as field>
	<#if field.hasDefaultValue()>
    public boolean is${field.getMethodFieldName()}Default(${field.fieldType.getName()} ${field.fieldName}){
        return ${field.fieldName} == ${field.fieldName}_DEFAULT;
    }
    </#if>

	<#if field.isOrigin()>
    <#if field.fieldType.isPrimitive()>
    public void set${field.getMethodFieldName()} (${field.fieldType.getName()} ${field.fieldName}) {
        this.${field.fieldName} = ${field.fieldName};
    }

    public ${field.fieldType.getName()} get${field.getMethodFieldName()}() {
        return this.${field.fieldName};
    }
    <#elseif field.fieldType.isString()>
    public void set${field.getMethodFieldName()} (String ${field.fieldName}){
        this.${field.fieldName} = ${field.fieldName};
    }

    public String get${field.getMethodFieldName()}() {
        return ${field.fieldName};
    }
    <#elseif field.fieldType.isArray()>

    public void set${field.getMethodFieldName()} (${field.subFieldType.getName()}[] ${field.fieldName}){
        this.${field.fieldName} = ${field.fieldName};
    }

    public ${field.subFieldType.getName()}[] get${field.getMethodFieldName()}() {
        return ${field.fieldName};
    }
    <#elseif field.fieldType.isClass()>
     public void set${field.getMethodFieldName()} (${field.className} ${field.fieldName}){
        this.${field.fieldName} = ${field.fieldName};
    }

    public ${field.className} get${field.getMethodFieldName()}() {
        return ${field.fieldName};
    }
    </#if>
    <#else>
    <#if field.fieldType.isPrimitive()>
    public void set${field.getMethodFieldName()} (${field.fieldType.getName()} ${field.fieldName}) {
        UnsafeMemoryManager.put${field.fieldType.getSuffix()}(address + ${field.fieldName}_OFFSET, ${field.fieldName});
    }

    public ${field.fieldType.getName()} get${field.getMethodFieldName()}() {
        return UnsafeMemoryManager.get${field.fieldType.getSuffix()}(address + ${field.fieldName}_OFFSET);
    }
    <#elseif field.fieldType.isString()>
    public void set${field.getMethodFieldName()} (String ${field.fieldName}){
        this.${field.fieldName} = new OffHeapString(${field.fieldName});
    }

    public String get${field.getMethodFieldName()}() {
        if (${field.fieldName} == null) {
            return null;
        }
        return ${field.fieldName}.getObject();
    }

    public OffHeapString getRaw${field.getMethodFieldName()}() {
        return this.${field.fieldName};
    }
    <#elseif field.fieldType.isArray()>

    public void set${field.getMethodFieldName()} (${field.subFieldType.getName()}[] ${field.fieldName}){
        this.${field.fieldName} = new OffHeap${field.subFieldType.getSuffix()}Array(${field.fieldName});
    }

    public ${field.subFieldType.getName()}[] get${field.getMethodFieldName()}() {
        if (${field.fieldName} == null) {
            return null;
        }
        return ${field.fieldName}.getObject();
    }

    public OffHeap${field.subFieldType.getSuffix()}Array getRaw${field.getMethodFieldName()}() {
        return this.${field.fieldName};
    }
    <#elseif field.fieldType.isClass()>
     public void set${field.getMethodFieldName()} (${field.className} ${field.fieldName}){
        this.${field.fieldName} = ${field.fieldName};
    }

    public ${field.className} get${field.getMethodFieldName()}() {
        return ${field.fieldName};
    }
    </#if>
	</#if>
	</#list>
}
