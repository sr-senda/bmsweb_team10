package bean;

public class Admin {

	private String userid;		// ユーザー名
	private String password;	// パスワード

	public Admin() {
		this.userid = null;
		this.password = null;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
