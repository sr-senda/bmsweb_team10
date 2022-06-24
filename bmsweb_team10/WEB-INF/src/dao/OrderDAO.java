
package dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
				// sqlのDateで受け取り、utilのDateに変換する
				java.sql.Timestamp timestamp = rs.getTimestamp("orderday");
				order.setOrderday(timestamp);

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
			String str = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(order.getOrderday());

			// SQL文
			String sql = "INSERT INTO orderinfo VALUES(0,'" + order.getUserid() + "', '" + order.getName() + "', '"
					+ order.getProductid() + " ', " + order.getQuantity() + "," + order.getSumprice() + ",'"
					+ str + "','" + order.getAddress() + "', '" + order.getMail() + "','"
					+ order.getPayment() + "','" + order.getDelivery() + "')";

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

	public void update(Order orderinfo) {

		Connection con = null;
		Statement smt = null;

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

	// 検索する
	public Order selectByOrderid(String orderid) {

		String sql = "SELECT * FROM orderinfo where orderid = '" + orderid + "'";

		Connection con = null;
		Statement smt = null;
		Order order = new Order();

		try {
			con = getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			// 注文一覧をorderオブジェクトに格納し、order_listtに入れる
			while (rs.next()) {

				order.setOrderid(rs.getString("orderid"));
				order.setName(rs.getString("name"));
				order.setProductid(rs.getString("productid"));
				order.setQuantity(rs.getInt("quantity"));
				order.setSumprice(rs.getInt("sumprice"));
				order.setOrderday(rs.getDate("orderday"));
				order.setPayment(rs.getString("payment"));
				order.setDelivery(rs.getString("delivery"));
				// メールアドレス送信用にメールアドレス情報を受け取る
				order.setMail(rs.getString("mail"));

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
		return order;

	}
}
