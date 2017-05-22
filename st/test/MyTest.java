import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class MyTest {
	public ParseTree getParseTree(CharStream input) throws Exception {
		stLexer lexer = new stLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		stParser parser = new stParser(tokens);
		return parser.prog();
	}

	@Test
	public void evaluateModel1() throws Exception {
		// pre-condition
		CharStream input = CharStreams.fromFileName("test/empty_program.st"); // FIXME: path
		ParseTreeWalker walker = new ParseTreeWalker();
		ModelCreator creator = new ModelCreator();

		// target
		walker.walk(creator, getParseTree(input));

		// post-condition
		Program program = creator.getModel();
		assertThat(program, is(notNullValue()));
		assertThat(program.getName(), is(equalTo("empty_program")));
	}

	@Test
	public void evaluateModel2() throws Exception {
		// pre-condition
		CharStream input = CharStreams.fromFileName("test/empty_program_with_comment.st"); // FIXME: path
		ParseTreeWalker walker = new ParseTreeWalker();
		ModelCreator creator = new ModelCreator();

		// target
		walker.walk(creator, getParseTree(input));

		// post-condition
		Program program = creator.getModel();
		assertThat(program, is(notNullValue()));
		assertThat(program.getName(), is(equalTo("empty_program_with_comment")));
	}
}
