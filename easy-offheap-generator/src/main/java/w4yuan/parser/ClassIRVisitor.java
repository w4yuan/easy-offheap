package w4yuan.parser;

import w4yuan.ClassIR;
import w4yuan.FieldIR;
import w4yuan.FieldType;
import w4yuan.TerminationException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClassIRVisitor extends EasyOffheapBaseVisitor<Void> {

	List<ClassIR> classIRList = null;

	public ClassIRVisitor() {
		classIRList = new ArrayList<>();
	}

	@Override
	public Void visitIdlFile(EasyOffheapParser.IdlFileContext ctx) {

		String packageName = null;
		EasyOffheapParser.PackageContext packageContext = ctx.package_();
		if (packageContext != null) {
			packageName = packageContext.package_name().getText();
		}

		List<EasyOffheapParser.StructDefContext> structDefContexts = ctx.structDef();

		for (EasyOffheapParser.StructDefContext structDefContext : structDefContexts) {
			ClassIR classIR = new ClassIR();
			classIR.setClassName(structDefContext.ID().getText());
			classIR.setPackageName(packageName);
			List<EasyOffheapParser.FieldDefContext> fieldDefContexts = structDefContext.fieldDef();
			List<FieldIR> fieldIRList = new ArrayList<>(fieldDefContexts.size());
			Set<Integer> order = new HashSet<>(fieldDefContexts.size());
			for (EasyOffheapParser.FieldDefContext fieldDefContext : fieldDefContexts) {
				FieldIR fieldIR = new FieldIR();
				if (fieldDefContext.ORIGIN() != null) {
					fieldIR.setOrigin(true);
				}
				// array
				if (fieldDefContext.REPEATED() != null) {
					fieldIR.setFieldType(FieldType.ARRAY);
					fieldIR.setSubFieldType(convert(fieldDefContext.fieldType()));
				} else {
					fieldIR.setFieldType(convert(fieldDefContext.fieldType()));
				}
				if (fieldIR.getFieldType().isObject()) {
					fieldIR.setClassName(fieldDefContext.fieldType().getText());
				}
				fieldIR.setOrder(Integer.parseInt(fieldDefContext.INTLIT().getText()));
				if (order.contains(fieldIR.getOrder())) {
					throw new TerminationException("Order " + fieldIR.getOrder() + " repeated.");
				}
				order.add(fieldIR.getOrder());
				fieldIR.setFieldName(fieldDefContext.ID().getText());
				if (fieldIR.getFieldType().isPrimitive() && fieldDefContext.defaultDef() != null) {
					fieldIR.setDefaultValue(fieldDefContext.defaultDef().defValue().getText());
				}

				fieldIRList.add(fieldIR);
			}
			classIR.setFieldIRList(fieldIRList);
			classIRList.add(classIR);
		}
		return super.visitIdlFile(ctx);
	}

	private FieldType convert(EasyOffheapParser.FieldTypeContext type) {
		String text = type.getText();
		for (FieldType fieldType : FieldType.values()) {
			if (fieldType.getName().equals(text)) {
				return fieldType;
			}
		}
		return FieldType.CLASS;
	}

	public List<ClassIR> getClassIRList() {
		return classIRList;
	}
}
