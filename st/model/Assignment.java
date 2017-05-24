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

	public void probeEquivalence(Statement other, Notification notification) {
		if(other instanceof Assignment == false) {
			String error_msg = other + " is not a instance of " + Assignment.class.getName() + "\n";
			notification.error(error_msg);
			return;
		}

		Assignment other_assign = (Assignment)other;
		if(! _lhs.equals(other_assign._lhs))
		{
			String error_msg = String.format("lhs is different. [%s], [%s]\n", _lhs, other_assign._lhs);
			notification.error(error_msg);
		}
		if(! _rhs.equals(other_assign._rhs))
		{
			String error_msg = String.format("rhs is different. [%s], [%s]\n", _rhs, other_assign._rhs);
			notification.error(error_msg);
		}
	}

	private String _lhs;
	private String _rhs;
}
