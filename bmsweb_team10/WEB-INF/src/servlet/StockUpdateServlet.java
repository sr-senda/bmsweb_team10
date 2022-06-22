/*
 * 作成日：2022/06/22
 * 作成者：田中梨貴
 * 内容：在庫数更新（サーブレット）
 */
package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.Product;
import dao.ProductDAO;

public class StockUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		ProductDAO productDao = new ProductDAO();
		Product product = new Product();

		response.setContentType("text/html; charset=UTF-8");// エンコードの設定

		// パラメータ取得
		String productid = request.getParameter("productid");
		String cmd = request.getParameter("cmd");


		if (cmd.equals("update")) {
			// 入力された在庫数をproductオブジェクトに格納
			product.setProductid(productid);
			product.setStock(Integer.parseInt(request.getParameter("stock")));
			//在庫数を更新
			productDao.update(product);
			request.getRequestDispatcher("/productlist").forward(request, response); // 商品一覧にフォワード
		}else if(cmd.equals("detail")) {
			product = productDao.selectByProductid(productid); // 商品情報の取得
			request.setAttribute("product",product);
			request.getRequestDispatcher("/view/admin/productUpdate.jsp").forward(request, response); // 商品一覧にフォワード
		}
	}
}
