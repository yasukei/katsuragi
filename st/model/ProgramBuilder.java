//import org.antlr.v4.runtime.ParserRuleContext;

public class ProgramBuilder extends stBaseListener {
	@Override public void enterProg_name(stParser.Prog_nameContext ctx) {
		String prog_name = String.valueOf(ctx.ID().getText());
		_prog = new Program(prog_name);
	}

	@Override public void enterVar_decl(stParser.Var_declContext ctx) {
		String var_name = String.valueOf(ctx.var_name().getText());
		String var_type = String.valueOf(ctx.var_type().getText());
		_prog.addVariable(new Variable(var_name, var_type));
	}

	@Override public void enterAssignment(stParser.AssignmentContext ctx) {
		String var_name = String.valueOf(ctx.var_name().getText());
		String expression = String.valueOf(ctx.expression().getText());
		_prog.addStatement(new Assignment(var_name, expression));
	}

	public Program getProgram() {
		return _prog;
	}

	private Program _prog;
}
