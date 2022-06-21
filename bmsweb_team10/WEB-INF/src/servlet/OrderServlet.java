package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.Order;
import dao.OrderDAO;

public class OrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException ,IOException{

		// 入力データの文字コードの指定
		request.setCharacterEncoding("UTF-8");

		//パラメータの取得
		String userid = request.getParameter("userid");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String address = request.getParameter("address");
		String productid = request.getParameter("productid");


		//OrderDAOオブジェクト生成
		OrderDAO ordDao = new OrderDAO();

		//Orderのオブジェクト生成し、各setterメソッドを利用し、値を設定する
		Order order = new Order();
		order.setUserid(userid);
		order.setName(name);
		order.setMail(mail);
		order.setAddress(address);
		order.setProductid(productid);

		//Orderオブジェクトを引数として、メソッドを呼び出す
		ordDao.orderInsert(order);

		//フォワード
		request.getRequestDispatcher("/menu").forward(request, response);
	}

}
