package w4yuan;

import freemarker.cache.TemplateLoader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class SpecialTemplateLoader implements TemplateLoader {

	private Reader reader;

	@Override
	public Object findTemplateSource(String s) throws IOException {
		return s;
	}

	@Override
	public long getLastModified(Object o) {
		return 0;
	}

	@Override
	public Reader getReader(Object o, String s) throws IOException {
		InputStream resourceAsStream = IRConvertor.class.getClassLoader()
				.getResourceAsStream("template/easy_offheap.ftl");
		reader = new InputStreamReader(resourceAsStream);
		return reader;
	}

	@Override
	public void closeTemplateSource(Object o) throws IOException {
		if (reader != null) {
			reader.close();
		}
	}
}
