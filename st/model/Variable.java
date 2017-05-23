public class Variable {
	public Variable(String var_name, String type_name) {
		_var_name = var_name;
		_var_type = type_name;
	}

	public String getName() {
		return _var_name;
	}

	public String getType() {
		return _var_type;
	}

	private String _var_name;
	private String _var_type;
}
