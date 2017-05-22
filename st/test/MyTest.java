import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

//import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class MyTest {
	@Test
	public void evaluateModel() throws Exception {
		CharStream input = CharStreams.fromStream(System.in);
		stLexer lexer = new stLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		stParser parser = new stParser(tokens);
		ParseTree tree = parser.prog();
		ParseTreeWalker walker = new ParseTreeWalker();
		ModelCreator creator = new ModelCreator();
		walker.walk(creator, tree);

		Program program = creator.getModel();
		assertThat(program, is(notNullValue()));
		assertThat(program.getName(), is(equalTo("empty_program")));
	}
}
