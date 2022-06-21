package dao;

import java.sql.*;
import bean.User;

public class UserDAO {

	private static String RDB_DRIVE = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost/uniformdb";
	private static String USER = "root";
	private static String PASSWD = "root123";

	public Connection getConnection() {

		try {
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}

	}

	public User selectByUser(String userid, String password) {

		Connection con = null;
		Statement smt = null;
		User user = new User();

		String sql = "SELECT * FROM userinfo WHERE userid ='" + userid + "' AND password='" + password + "'";

		try {

			con = getConnection();
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);

			if (rs.next()) {
				user.setUserid(rs.getString("userid"));
				user.setPassword(rs.getString("password"));
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return user;
	}

	// 会員情報を登録する
	public void insert(User user) {

		// 変数宣言
		Connection con = null;
		Statement smt = null;

		// SQL文作成
		String sql = "INSERT INTO userinfo VALUES('" + user.getUserid() + "','" + user.getName() + "','"
				+ user.getMail() + "','" + user.getAddress() + "','" + user.getPassword() + "')";

		try {
			// DBに接続
			con = getConnection();
			smt = con.createStatement();

			// SQL文を発行
			smt.executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);

			// データベース接続を終了
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}

		}

	}

	// 会員IDをもとに検索する
	public User selectByUserId(String userid) {

		Connection con = null;
		Statement smt = null;

		User user = new User();

		String sql = "SELECT * FROM userinfo WHERE userid ='" + userid + "'";

		try {

			// DBに接続
			con = getConnection();
			smt = con.createStatement();

			// SQL文を発行
			ResultSet rs = smt.executeQuery(sql);

			if (rs.next()) {
				user.setUserid(rs.getString("userid"));
				user.setName(rs.getString("name"));
				user.setMail(rs.getString("mail"));
				user.setAddress(rs.getString("address"));
				user.setPassword(rs.getString("password"));
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return user;
	}

	// データベースの書籍データを更新するインスタンスメソッド
	public void update(User user) {

		Connection con = null;
		Statement smt = null;

		// SQL文作成
		String sql = "UPDATE userinfo SET name='" + user.getName() + "',mail='" + user.getMail() + "',address='"
				+ user.getAddress() + "' WHERE userid='" + user.getUserid() + "'";

		try {

			// DBに接続
			con = getConnection();
			smt = con.createStatement();

			// SQL文を発行
			smt.executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);

			// データベース接続を終了
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
	}

}
