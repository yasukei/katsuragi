//import org.antlr.v4.runtime.ParserRuleContext;

public class ModelCreator extends stBaseListener {
	@Override public void enterProg_name(stParser.Prog_nameContext ctx) {
		String prog_name = String.valueOf(ctx.ID().getText());
		_prog = new Program(prog_name);
	}

	public Program getModel() {
		return _prog;
	}

	private Program _prog;
}
