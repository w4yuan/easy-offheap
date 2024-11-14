// Generated from /Users/siyuan03.wang/code/h2o/easy-offheap-generator/src/main/java/com/vip/easy_offheap/parser/EasyOffheap.g4 by ANTLR 4.13.1
package w4yuan.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EasyOffheapParser}.
 */
public interface EasyOffheapListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EasyOffheapParser#idlFile}.
	 * @param ctx the parse tree
	 */
	void enterIdlFile(EasyOffheapParser.IdlFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyOffheapParser#idlFile}.
	 * @param ctx the parse tree
	 */
	void exitIdlFile(EasyOffheapParser.IdlFileContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyOffheapParser}.
	 * @param ctx the parse tree
	 */
	void enterPackage(EasyOffheapParser.PackageContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyOffheapParser}.
	 * @param ctx the parse tree
	 */
	void exitPackage(EasyOffheapParser.PackageContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyOffheapParser#package_name}.
	 * @param ctx the parse tree
	 */
	void enterPackage_name(EasyOffheapParser.Package_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyOffheapParser#package_name}.
	 * @param ctx the parse tree
	 */
	void exitPackage_name(EasyOffheapParser.Package_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyOffheapParser#structDef}.
	 * @param ctx the parse tree
	 */
	void enterStructDef(EasyOffheapParser.StructDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyOffheapParser#structDef}.
	 * @param ctx the parse tree
	 */
	void exitStructDef(EasyOffheapParser.StructDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyOffheapParser#fieldDef}.
	 * @param ctx the parse tree
	 */
	void enterFieldDef(EasyOffheapParser.FieldDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyOffheapParser#fieldDef}.
	 * @param ctx the parse tree
	 */
	void exitFieldDef(EasyOffheapParser.FieldDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyOffheapParser#defaultDef}.
	 * @param ctx the parse tree
	 */
	void enterDefaultDef(EasyOffheapParser.DefaultDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyOffheapParser#defaultDef}.
	 * @param ctx the parse tree
	 */
	void exitDefaultDef(EasyOffheapParser.DefaultDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyOffheapParser#defValue}.
	 * @param ctx the parse tree
	 */
	void enterDefValue(EasyOffheapParser.DefValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyOffheapParser#defValue}.
	 * @param ctx the parse tree
	 */
	void exitDefValue(EasyOffheapParser.DefValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyOffheapParser#fieldType}.
	 * @param ctx the parse tree
	 */
	void enterFieldType(EasyOffheapParser.FieldTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyOffheapParser#fieldType}.
	 * @param ctx the parse tree
	 */
	void exitFieldType(EasyOffheapParser.FieldTypeContext ctx);
}
