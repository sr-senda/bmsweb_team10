package servlet;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.Order;
import dao.OrderDAO;

public class OrderListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{

		OrderDAO orderDao = new OrderDAO();

		// selectAllメソッドを使って商品の全データを取得する
		ArrayList<Order> order_list = orderDao.selectAll();

		// 取得した商品データをリクエストスコープに登録する
		request.setAttribute("order_list", order_list);
		request.getRequestDispatcher("/view/admin/list.jsp").forward(request,response);

	}

}
