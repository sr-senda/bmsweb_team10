package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.Order;
import bean.User;
import dao.OrderDAO;

public class OrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException ,IOException{

		String error = ""; //エラーメッセージ格納
		String cmd = ""; //エラーコマンド格納

		try {

		// 入力データの文字コードの指定
		request.setCharacterEncoding("UTF-8");

		//OrderDAOオブジェクト生成
		OrderDAO orderDao = new OrderDAO();
		Order order = new Order();

		//パラメータの取得,セット
		order.setUserid(request.getParameter("userid"));
		order.setName(request.getParameter("name"));
		order.setMail(request.getParameter("mail"));
		order.setAddress(request.getParameter("address"));
		order.setProductid(request.getParameter("product"));
		order.setQuantity(Integer.parseInt(request.getParameter("quantity")));

		//未入力チェック
		//if(userid.equals(""){
			//error = "会員IDが未入力の為、注文処理は行えませんでした。"
			//cmd = "menu";
			//return;
		//}
		//if(name.equals(""){
			//error = "氏名が未入力の為、注文処理は行えませんでした。"
			//cmd = "menu";
			//return;
		//}
		//if(mail.equals(""){
			//error = "メールアドレスが未入力の為、注文処理は行えませんでした。"
			//cmd = "menu";
			//return;
		//}
		//if(address.equals(""){
			//error = "住所が未入力の為、注文処理は行えませんでした。"
			//cmd = "menu";
			//return;
		//}

		//Orderオブジェクトを引数として、メソッドを呼び出す
		orderDao.orderInsert(order);

		//会員情報を格納するUserオブジェクトを定義
		User userInfo = new User();
		userInfo.setUserid(request.getParameter("userid"));
		userInfo.setName(request.getParameter("name"));
		userInfo.setMail(request.getParameter("mail"));
		userInfo.setAddress(request.getParameter("address"));
		userInfo.setPassword("senda");
		request.setAttribute("userInfo", userInfo);

		}catch(IllegalStateException e) {
			error = "DB接続エラーの為、注文処理は行えませんでした。";
			cmd = "menu";

		//メニューへフォワード
		request.getRequestDispatcher("/view/user/menu.jsp").forward(request, response);
	}

}
}
