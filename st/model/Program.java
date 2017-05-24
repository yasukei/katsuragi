import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Program {
	public Program(String name) {
		_name = name;
		_symbol_table = new HashMap<String, Variable>();
		_statements = new ArrayList<Statement>();
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

	public void probeEquivalence(Program other, Notification notification) {
		if(! _name.equals(other._name)) {
			String error_msg = String.format("Names are different. [%s], [%s]\n", _name, other._name);
			notification.error(error_msg);
		}
		probeSymbolTableEquivalence(_symbol_table, other._symbol_table, notification);
		probeSymbolTableEquivalence(other._symbol_table, _symbol_table, notification);
		probeStatementsEquivalence(_statements, other._statements, notification);
		probeStatementsEquivalence(other._statements, _statements, notification);
	}

	private static void probeSymbolTableEquivalence(Map<String, Variable> lhs, Map<String, Variable> rhs, Notification notification) {
		for(Map.Entry<String, Variable> lhs_elem : lhs.entrySet()) {
			Variable rhs_value = rhs.get(lhs_elem.getKey());
			if(rhs_value == null) {
				String error_msg = String.format("the one has [%s] but another does not have it\n", lhs_elem.getKey());
				notification.error(error_msg);
				return;
			}
			lhs_elem.getValue().probeEquivalence(rhs_value, notification);
		}
	}
	private static void probeStatementsEquivalence(List<Statement> lhs, List<Statement> rhs, Notification notification) {
		if(lhs.size() != rhs.size()) {
				String error_msg = String.format("The number of Statement is different. [%d], [%d]", lhs.size(), rhs.size());
				notification.error(error_msg);
		}

		int limit = lhs.size() < rhs.size() ? lhs.size() : rhs.size();
		for(int i = 0; i < limit; i++) {
			lhs.get(i).probeEquivalence(rhs.get(i), notification);
		}
	}

	private String _name;
	private Map<String, Variable> _symbol_table;
	private List<Statement> _statements;
}

