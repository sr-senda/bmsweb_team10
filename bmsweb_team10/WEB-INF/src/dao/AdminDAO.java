package dao;

import java.sql.*;
import bean.Admin;
import bean.Order;

public class AdminDAO {

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

	public Admin selectByAdminer(String adminid, String password) {

		Connection con = null;
		Statement smt = null;
		Admin admin = new Admin();

		String sql = "SELECT * FROM admininfo WHERE adminid ='" + adminid + "' AND password='" + password + "'";

		try {

			con = getConnection();
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);

			if (rs.next()) {
				admin.setUserid(rs.getString("adminid"));
				admin.setPassword(rs.getString("password"));
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
		return admin;
	}

	public void update(Order orderinfo) {

		Connection con = null;
		Statement smt = null;
		System.out.println(orderinfo.getPayment());

		try {

			// 引数の情報を利用し、更新用のSQL文を文字列として定義
			String sql = "UPDATE orderinfo SET payment='" + orderinfo.getPayment() + "',delivery='"
					+ orderinfo.getDelivery() + "' WHERE orderid='" + orderinfo.getOrderid() + "'";

			// BookDAOクラスに定義したgetConnection()メソッドを利用して、Connectionオブジェクトを生成
			con = getConnection();

			// ConnectionオブジェクトのcreateStatement（）メソッドを利用して、Statementオブジェクトを生成
			smt = con.createStatement();

			// StatementオブジェクトのexecuteUpdate（）メソッドを利用して、SQL文を発行し書籍データを変更
			smt.executeUpdate(sql);

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
	}

}
