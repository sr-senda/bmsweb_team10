/*
 * 作成日：2022/06/21
 * 作成者：田中梨貴
 * 内容：在庫数更新（サーブレット）
 */
package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.Product;
import dao.ProductDAO;

public class StockUpdateServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{

		ProductDAO productDao = new ProductDAO();
		Product product = new Product();

		response.setContentType("text/html; charset=UTF-8");// エンコードの設定

		//入力された在庫数をproductオブジェクトに格納
		product.setStock(Integer.parseInt(request.getParameter("stock")));

		productDao.update(product);

		//request.getRequestDispatcher("/productlist").forward(request, response); //商品一覧にフォワード
	}
}
