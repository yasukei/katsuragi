import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class MyTest {
	public Program buildProgram(String filepath) throws Exception {
		CharStream input = CharStreams.fromFileName(filepath);
		stLexer lexer = new stLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		stParser parser = new stParser(tokens);
		ParseTreeWalker walker = new ParseTreeWalker();
		ProgramBuilder builder = new ProgramBuilder();

		walker.walk(builder, parser.program());

		return builder.buildProgram();
	}

	public void assertProgram(Program target, Program expect) throws Exception {
		Notification notification = new Notification();
		target.probeEquivalence(expect, notification);
		if(notification.hasError()) {
			throw new Exception(notification.getErrorMsg());
		}
	}

	@Test
	public void evaluateModel1() throws Exception {
		Program program = buildProgram("test/empty_program.st");
		Program expect = new Program("empty_program");

		assertThat(program, is(notNullValue()));
		assertProgram(program, expect);
	}

	@Test
	public void evaluateModel2() throws Exception {
		Program program = buildProgram("test/empty_program_with_comment.st");
		Program expect = new Program("empty_program_with_comment");

		assertThat(program, is(notNullValue()));
		assertProgram(program, expect);
	}

	@Test
	public void evaluateModel3() throws Exception {
		Program program = buildProgram("test/variable_assignment.st");
		Program expect = new Program("variable_assignment");
		expect.addVariable(new Variable("x", "INT"));
		expect.addStatement(new Assignment("x", "1"));

		assertThat(program, is(notNullValue()));
		assertProgram(program, expect);
	}
}
