package dao;

import java.sql.*;
import java.util.ArrayList;
import bean.Product;

public class ProductDAO {

	private static String RDB_DRIVE = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost/uniformdb";
	private static String USER = "root";
	private static String PASSWD = "root123";

	// データベース接続
	public Connection getConnection() {

		try {
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}

	}

	// 商品一覧を検索する
	public ArrayList<Product> selectAll() {

		ArrayList<Product> product_list = new ArrayList<Product>();
		String sql = "SELECT * FROM productinfo ORDER BY productid";

		Connection con = null;
		Statement smt = null;
		try {
			con = getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			// 商品一覧をproductオブジェクトに格納し、product_listに入れる
			while (rs.next()) {
				Product product = new Product();
				product.setProductid(rs.getString("productid"));
				product.setProductname(rs.getString("productname"));
				product.setPrice(rs.getInt("price"));
				product.setStock(rs.getInt("stock"));

				product_list.add(product);
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
		// 取得した商品の全データを戻り値にする
		return product_list;

	}

	// データベースの在庫数を更新するインスタンスメソッドupdateを定義
	public void update(Product product) {
		Connection con = null;
		Statement smt = null;

		System.out.println(product.getProductid() + "," + product.getStock());
		try {
			// 引数を利用し、更新用のSQL文を定義
			String sql = "UPDATE productinfo SET stock =" + product.getStock() + " = Where productid='"
					+ product.getProductid() + "'";

			// Connection,Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();
			// executeUpdate()メソッドを利用してSQL文を発行し書籍データを更新
			smt.executeUpdate(sql);
			// Statement,Connectionをクローズ
			smt.close();
			con.close();

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
