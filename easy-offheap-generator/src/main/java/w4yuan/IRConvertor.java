package w4yuan;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class IRConvertor {

	public static void convert(String basePath, ClassIR classIR) throws IOException, TemplateException {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateLoader(new SpecialTemplateLoader());
		String path = basePath;
		Template template = cfg.getTemplate("easy_offheap.ftl");
		if (classIR.getPackageName() != null) {
			path += classIR.getPackageName().replace('.', '/');
			path += "/";
		}
		StringBuilder stringBuilder = new StringBuilder(200);
		int offset = 0;
		String lineSeparator = System.lineSeparator();
		for (FieldIR fieldIR : classIR.getFieldIRList()) {
			if (fieldIR.isOrigin()) {
				if (fieldIR.getFieldType().isObject()) {
					if (fieldIR.getFieldType().isString()) {
						stringBuilder.append("    private String ").append(fieldIR.getFieldName()).append(';')
								.append(lineSeparator);
					} else if (fieldIR.getFieldType().isArray()) {
						stringBuilder.append("    private ").append(fieldIR.getSubFieldType().getName()).append("[] ")
								.append(fieldIR.getFieldName()).append(';').append(lineSeparator);
					} else if (fieldIR.getFieldType().isClass()) {
						stringBuilder.append("    private ").append(fieldIR.getClassName()).append(" ")
								.append(fieldIR.getFieldName()).append(';').append(lineSeparator);
					}
				} else {
					stringBuilder.append("    private ").append(fieldIR.getFieldType().getName()).append(" ")
							.append(fieldIR.getFieldName()).append(';').append(lineSeparator);
					defaultValueAppend(fieldIR, stringBuilder, lineSeparator);
				}
			} else {
				if (fieldIR.getFieldType().isObject()) {
					if (fieldIR.getFieldType().isString()) {
						stringBuilder.append("    private OffHeapString ").append(fieldIR.getFieldName()).append(';')
								.append(lineSeparator);
					} else if (fieldIR.getFieldType().isArray()) {
						stringBuilder.append("    private OffHeap").append(fieldIR.getSubFieldType().getSuffix())
								.append("Array ").append(fieldIR.getFieldName()).append(';').append(lineSeparator);
					} else if (fieldIR.getFieldType().isClass()) {
						stringBuilder.append("    private ").append(fieldIR.getClassName()).append(" ")
								.append(fieldIR.getFieldName()).append(';').append(lineSeparator);
					}
				} else {
					stringBuilder.append("    public static final int ").append(fieldIR.getFieldName())
							.append("_OFFSET = ").append(offset).append(';').append(lineSeparator);
					defaultValueAppend(fieldIR, stringBuilder, lineSeparator);
					offset += fieldIR.getFieldType().getBytes();
				}
			}
		}
		classIR.setTotalBytes(offset);
		classIR.setFieldStr(stringBuilder.toString());
		FileWriter fileWriter = new FileWriter(path + classIR.getClassName() + ".java");
		Map<String, Object> map = new HashMap<>();
		map.put("classIR", classIR);
		template.process(map, fileWriter);
	}

	private static void defaultValueAppend(FieldIR fieldIR, StringBuilder stringBuilder, String lineSeparator) {
		if (fieldIR.hasDefaultValue()) {
			if (fieldIR.getFieldType().isChar()) {
				stringBuilder.append("    private static final ").append(fieldIR.getFieldType().getName()).append(" ")
						.append(fieldIR.getFieldName()).append("_DEFAULT = '").append(fieldIR.getDefaultValue())
						.append("';").append(lineSeparator);
			} else if (fieldIR.getFieldType().isFloat()) {
				stringBuilder.append("    private static final ").append(fieldIR.getFieldType().getName()).append(" ")
						.append(fieldIR.getFieldName()).append("_DEFAULT = ").append(fieldIR.getDefaultValue())
						.append("F;").append(lineSeparator);
			} else {
				stringBuilder.append("    private static final ").append(fieldIR.getFieldType().getName()).append(" ")
						.append(fieldIR.getFieldName()).append("_DEFAULT = ").append(fieldIR.getDefaultValue())
						.append(';').append(lineSeparator);
			}
		}
	}

}
