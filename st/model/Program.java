import java.util.HashMap;
import java.util.ArrayList;

public class Program {
	public Program(String name) {
		_name = name;
	}

	public String getName() {
		return _name;
	}

	public void addVariable(Variable var) {
		_symbol_table.put(var.getName(), var);
	}

	public void addStatement(Statement stat) {
		_statements.add(stat);
	}

	private String _name;
	private HashMap<String, Variable> _symbol_table;
	private ArrayList<Statement> _statements;
}

