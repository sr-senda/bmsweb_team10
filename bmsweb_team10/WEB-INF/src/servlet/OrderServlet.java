package servlet;

import java.io.*;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.Order;
import bean.Product;
import bean.User;
import dao.OrderDAO;
import dao.ProductDAO;
import util.SendMail;

public class OrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = ""; // エラーメッセージ格納
		String cmd = ""; // エラーコマンド格納

		try {

			// 入力データの文字コードの指定
			request.setCharacterEncoding("UTF-8");

			// OrderDAOオブジェクト生成
			OrderDAO orderDao = new OrderDAO();
			Order order = new Order();

			ProductDAO productDao = new ProductDAO();
			Date dateObj = new Date();
			int sumprice = 0;

			Product product = productDao.selectByProductid(request.getParameter("product"));

			// 合計金額
			if(request.getParameter("product").equals("001")) {
				sumprice += product.getPrice() * Integer.parseInt(request.getParameter("quantity"));
			}
			// 在庫数減少
			int stock = product.getStock() - Integer.parseInt(request.getParameter("quantity"));

			// パラメータの取得,セット
			order.setUserid(request.getParameter("userid"));
			order.setName(request.getParameter("name"));
			order.setMail(request.getParameter("mail"));
			order.setAddress(request.getParameter("address"));
			order.setProductid(request.getParameter("product"));
			order.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			order.setOrderday(dateObj);
			order.setSumprice(sumprice);
			order.setPayment("1");
			order.setDelivery("1");

			// 未入力チェック
			// if(userid.equals(""){
			// error = "会員IDが未入力の為、注文処理は行えませんでした。"
			// cmd = "menu";
			// return;
			// }
			// if(name.equals(""){
			// error = "氏名が未入力の為、注文処理は行えませんでした。"
			// cmd = "menu";
			// return;
			// }
			// if(mail.equals(""){
			// error = "メールアドレスが未入力の為、注文処理は行えませんでした。"
			// cmd = "menu";
			// return;
			// }
			// if(address.equals(""){
			// error = "住所が未入力の為、注文処理は行えませんでした。"
			// cmd = "menu";
			// return;
			// }

			// Orderオブジェクトを引数として、メソッドを呼び出す
			orderDao.orderInsert(order);
			productDao.updateStock(request.getParameter("product"), stock);

			// メール機能
			product = productDao.selectByProductid(order.getProductid());

			SendMail sendMail = new SendMail();
			sendMail.OrderMail(order,product);

			// 会員情報を格納するUserオブジェクトを定義
			User userInfo = new User();
			userInfo.setUserid(request.getParameter("userid"));
			userInfo.setName(request.getParameter("name"));
			userInfo.setMail(request.getParameter("mail"));
			userInfo.setAddress(request.getParameter("address"));
			userInfo.setPassword("senda");
			request.setAttribute("userInfo", userInfo);

			// メニューへフォワード
			request.getRequestDispatcher("/view/user/menu.jsp").forward(request, response);
		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、注文処理は行えませんでした。";
			cmd = "menu";
		}


	}
}
