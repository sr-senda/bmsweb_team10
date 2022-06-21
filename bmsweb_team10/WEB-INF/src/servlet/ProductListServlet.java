package servlet;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.Product;
import dao.ProductDAO;;

public class ProductListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{

		ProductDAO productDao = new ProductDAO();

		// selectAllメソッドを使って商品の全データを取得する
		ArrayList<Product> product_list = productDao.selectAll();

		// 取得した商品データをリクエストスコープに登録する
		request.setAttribute("product_list", product_list);
		request.getRequestDispatcher("/view/admin/productList.jsp").forward(request,response);

	}

}
