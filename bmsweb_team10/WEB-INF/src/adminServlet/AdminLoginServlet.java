package adminServlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import bean.Admin;
import dao.AdminDAO;

	public class AdminLoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		// 入力したユーザー名とパスワードを受け取る
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		AdminDAO adminDao = new AdminDAO();
		Admin admin = null;
		admin = adminDao.selectByAdminer(id,password);

		// 入力したデータが一致してるか判定する
		if(id.equals(admin.getUserid()) && password.equals(admin.getPassword())) {

			// メニュー画面に遷移する
			request.getRequestDispatcher("/view/admin/menu.jsp").forward(request, response);

			// 入力したデータが間違ってたらログイン画面のまま
		}else {
			request.getRequestDispatcher("/view/admin/login.jsp").forward(request, response);
		}

	}

}
