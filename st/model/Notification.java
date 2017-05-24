import java.util.List;
import java.util.LinkedList;

class Notification {
	public Notification() {
		_error_msgs = new LinkedList<String>();
	}

	public void error(String error_msg) {
		_error_msgs.add(error_msg + "\n");
	}

	public String getErrorMsg() {
		StringBuilder error_msgs = new StringBuilder();
		for(String error_msg : _error_msgs) {
			error_msgs.append(error_msg);
		}
		return error_msgs.toString();
	}

	public boolean hasError() {
		if(_error_msgs.size() != 0) {
			return true;
		}
		return false;
	}

	private List<String> _error_msgs;
}
