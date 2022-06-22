package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Admin;
import bean.Order;
import dao.AdminDAO;
import dao.OrderDAO;

public class DetailServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			// オブジェクト生成
			OrderDAO admDao = new OrderDAO();

			// 注文情報を格納するAdminオブジェクトを生成
			Order admin = new Order();

			// 文字エンコーデキングの設定
			request.setCharacterEncoding("UTF-8");

			// 画面から送信されるorderidと情報をうけとる
			String orderid = request.getParameter("orderid");

			// 注文情報を取得
			admin = admDao.selectByOrderid(orderid);

			// 取得した〇〇情報を[admin]でリクエストスコープに登録
			request.setAttribute("admin", admin);

		} catch (IllegalStateException e) {

		} finally {

			request.getRequestDispatcher("/view/admin/detail.jsp").forward(request, response);

		}

	}
}
