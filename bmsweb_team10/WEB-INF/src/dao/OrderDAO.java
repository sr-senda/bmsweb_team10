package dao;

import java.sql.*;
import java.util.ArrayList;

import bean.Order;

public class OrderDAO {

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

	// 注文一覧を検索する
	public ArrayList<Order> selectAll() {

		ArrayList<Order> order_list = new ArrayList<Order>();
		String sql = "SELECT * FROM orderinfo ORDER BY orderid";

		Connection con = null;
		Statement smt = null;

		try {
			con = getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			// 注文一覧をorderオブジェクトに格納し、order_listtに入れる
			while (rs.next()) {
				Order order = new Order();
				order.setOrderid(rs.getString("orderid"));
				order.setName(rs.getString("name"));
				order.setOrderday(rs.getString("orderday"));

				order_list.add(order);
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
		// 取得した注文の全データを戻り値にする
		return order_list;

	}

	// データベースに注文内容を登録するインスタンスメソッドorderInsertを定義
	public void orderInsert(Order order) {

		Connection con = null;
		Statement smt = null;

		try {
			// DB接続
			con = getConnection();
			smt = con.createStatement();

			// SQL文
			String sql = "INSERT INTO orderinfo(userid, name, productid, quantity, address, mail)VALUES('"
					+ order.getUserid() + "' '" + order.getName() + "' '" + order.getAddress() + " ' '"
					+ order.getMail() + "' '" + order.getProductid() + "' '" + order.getQuantity() + ")";

			// SQL発行
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
