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

	public void probeEquivalence(Variable other, Notification notification) {
		if(! _var_name.equals(other._var_name))
		{
			String error_msg = String.format("name is different. [%s], [%s]\n", _var_name, other._var_name);
			notification.error(error_msg);
		}
		if(! _var_type.equals(other._var_type))
		{
			String error_msg = String.format("name is different. [%s], [%s]\n", _var_type, other._var_type);
			notification.error(error_msg);
		}
	}
	private String _var_name;
	private String _var_type;
}
