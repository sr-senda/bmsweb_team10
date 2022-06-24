package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import bean.User;
import dao.UserDAO;

public class UserLoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		String cmd = "";

		try {
			// userid,password入力パラメータを取得する
			String userid = (String) request.getParameter("id");
			String password = (String) request.getParameter("password");

			// UserDAOをインスタンス化し、ユーザー情報の検索をおこなう
			UserDAO userDaoObj = new UserDAO();
			User user = userDaoObj.selectByUser(userid, password);

			// ユーザー情報のチェック
			if (user.getUserid() == null) {
				error = "入力データが間違っています。";
				cmd = "login";
				return;
			}

			request.setAttribute("userInfo", user);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、ログイン出来ません。";
			cmd = "login";

		} finally {
			// エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				// エラーが無い場合はmenu.jspにフォワード
				request.getRequestDispatcher("/view/user/menu.jsp").forward(request, response);
			} else {
				// エラーが有る場合
				request.setAttribute("error", error);
				if (cmd.equals("login")) {
					// User情報がない場合
					request.getRequestDispatcher("/view/user/login.jsp").forward(request, response);
				} else {
					request.setAttribute("cmd", cmd);
					request.getRequestDispatcher("/view/error.jsp").forward(request, response);
				}
			}
		}

	}
}
