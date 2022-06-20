package bean;

public class User {

	private String userid;		// ユーザー名
	private String password;// パスワード
	private String name;	// 氏名
	private String mail;	// メールアドレス
	private String address;		// 住所

	public User() {
		this.userid = null;
		this.password = null;
		this.name = null;
		this.mail = null;
		this.address = null;
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

	public String getName() {
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
