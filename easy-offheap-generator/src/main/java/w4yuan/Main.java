package w4yuan;

import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws IOException, TemplateException {
		generate(args);
	}

	public static void generate(String[] args) throws TemplateException, IOException {
		String base;
		List<String> inputFiles = new ArrayList<>(8);

		if (args == null || args.length == 0) {
			throw new TerminationException("请输入文件");
		} else if (args.length == 1) {
			File f = getFile(args[0], inputFiles);
			if (!f.isDirectory()) {
				base = f.getAbsoluteFile().getParent();
			} else {
				base = f.getAbsolutePath();
			}
		} else if (args.length == 2) {
			getFile(args[0], inputFiles);
			base = args[1];
		} else {
			throw new TerminationException("参数输入值大于 2");
		}
		if (inputFiles.isEmpty()) {
			throw new TerminationException("请输入文件");
		}

		if (!base.endsWith("/")) {
			base += "/";
		}

		for (String s : inputFiles) {
			CodeGenerator.generate(base, s);
		}
	}

	private static File getFile(String inputFile, List<String> inputFiles) {
		File f = new File(inputFile);
		if (!f.exists()) {
			throw new TerminationException("文件不存在");
		}
		if (f.isDirectory()) {
			File[] files = f.listFiles();
			if (files == null) {
				throw new TerminationException("文件夹下面没有文件");
			}
			for (File file : files) {
				// 识别 eo 文件
				if (file.getName().endsWith(".eo")) {
					inputFiles.add(file.getAbsolutePath());
				}
			}
		}
		return f;
	}


}
