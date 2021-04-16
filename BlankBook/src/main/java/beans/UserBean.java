package beans;

import database.SQLcon;

public class UserBean {
	private String userName, password, email;

	private int userId;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean validate(UserBean bean) {

		if (SQLcon.connectSQL()) {
			return SQLcon.stateSQL(bean);
		}

		return false;
	}

	public void resetUserBean() {
		this.password = null;
		this.userName = null;
	}

}
