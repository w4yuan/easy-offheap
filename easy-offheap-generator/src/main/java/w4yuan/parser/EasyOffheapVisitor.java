// Generated from /Users/siyuan03.wang/code/h2o/easy-offheap-generator/src/main/java/com/vip/easy_offheap/parser/EasyOffheap.g4 by ANTLR 4.13.1
package w4yuan.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EasyOffheapParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EasyOffheapVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EasyOffheapParser#idlFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdlFile(EasyOffheapParser.IdlFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyOffheapParser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackage(EasyOffheapParser.PackageContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyOffheapParser#package_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackage_name(EasyOffheapParser.Package_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyOffheapParser#structDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDef(EasyOffheapParser.StructDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyOffheapParser#fieldDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDef(EasyOffheapParser.FieldDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyOffheapParser#defaultDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultDef(EasyOffheapParser.DefaultDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyOffheapParser#defValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefValue(EasyOffheapParser.DefValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyOffheapParser#fieldType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldType(EasyOffheapParser.FieldTypeContext ctx);
}
