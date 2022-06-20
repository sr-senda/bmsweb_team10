package dao;

import java.sql.*;
import bean.User;

public class UserDAO {

	private static String RDB_DRIVE="com.mysql.jdbc.Driver";
	private static String URL="jdbc:mysql://localhost/uniformdb";
	private static String USER="root";
	private static String PASSWD="root123";

	public Connection getConnection() {

		try {
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		}catch(Exception e){
			throw new IllegalStateException(e);
		}

	}

	public User selectByUser(String userid, String password) {

		Connection con = null;
		Statement smt =null;
		User user = new User();

		String sql = "SELECT * FROM userinfo WHERE adminid ='" + userid + "' AND password='" + password + "'";

		try {

			con = getConnection();
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);

			if(rs.next()) {
				user.setUserid(rs.getString("user"));
				user.setPassword(rs.getString("password"));
			}

		}catch(Exception e) {
			throw new IllegalStateException(e);
		}finally {
			if(smt != null) {
				try {smt.close();}catch(SQLException ignore){}
			}
			if(con != null) {
				try {con.close();}catch(SQLException ignore) {}
			}
		}
		return user;
	}

}
