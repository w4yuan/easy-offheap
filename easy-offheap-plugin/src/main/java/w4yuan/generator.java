package w4yuan;


import freemarker.template.TemplateException;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.IOException;

@Mojo(name = "generate")
public class generator extends AbstractMojo {

	@Parameter(name = "path", required = true)
	private String path;

	@Parameter(name = "target")
	private String target;

	public void execute() throws MojoExecutionException, MojoFailureException {
		try {
			String[] args;
			if (target == null || target.isEmpty()) {
				args = new String[]{path};
			} else {
				args = new String[]{path, target};
			}
			Main.generate(args);
		} catch (TemplateException | IOException e) {
			throw new RuntimeException(e);
		}
	}
}
