package w4yuan;

import freemarker.template.TemplateException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import w4yuan.parser.ClassIRVisitor;
import w4yuan.parser.EasyOffheapLexer;
import w4yuan.parser.EasyOffheapParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CodeGenerator {



	public static void generate(String output, String inputFile) throws IOException, TemplateException {
		ANTLRInputStream input = new ANTLRInputStream(Files.newInputStream(new File(inputFile).toPath()));
		EasyOffheapLexer lexer = new EasyOffheapLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		EasyOffheapParser parser = new EasyOffheapParser(tokens);

		// 生成语法树
		ParseTree tree = parser.idlFile();

		// 使用自定义的Visitor
		ClassIRVisitor visitor = new ClassIRVisitor();
		visitor.visit(tree);  // 遍历语法树

		for (ClassIR classIR : visitor.getClassIRList()) {
			IRConvertor.convert(output, classIR);
		}
	}


}
