/*
 * 作成日：2022/06/22
 * 作成者：田中梨貴
 * 内容：商品一覧（DAO）
 */
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
			String sql = "UPDATE productinfo SET stock =" + product.getStock() + " where productid='"+ product.getProductid() + "'";

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

	// 指定されたISBN情報を元にデータベースから書籍データを検索するインスタンスメソッドselectByIsbnを定義
		public Product selectByProductid(String productid) {
			Connection con = null;
			Statement smt = null;

			Product product = new Product();

			try {

				// 引数を利用し、検索用のSQL文を文字列として定義
				String sql = "SELECT productid,productname,price,stock FROM productinfo WHERE productid = '" + productid + "'";

				// Connection,Statementオブジェクトを生成
				con = getConnection();
				smt = con.createStatement();

				// SQL文を発行し結果セットを取得
				ResultSet rs = smt.executeQuery(sql);

				// 結果セットから書籍データを取り出しBookオブジェクトに格納
				while (rs.next()) {
					product.setProductid(rs.getString("productid"));
					product.setProductname(rs.getString("productname"));
					product.setPrice(rs.getInt("price"));
					product.setStock(rs.getInt("stock"));
				}

				// Statement,Connectionオブジェクトをクローズ
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
			return product;
		}
}
