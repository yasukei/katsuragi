public class Assignment implements Statement {
	public Assignment(String lhs, String rhs) {
		_lhs = lhs;
		_rhs = rhs;
	}

	public String getLHS() {
		return _lhs;
	}

	public String getRHS() {
		return _rhs;
	}

	private String _lhs;
	private String _rhs;
}
