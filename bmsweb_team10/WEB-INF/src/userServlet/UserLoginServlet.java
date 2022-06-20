package userServlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import bean.User;
import dao.UserDAO;

public class UserLoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		// 入力したユーザー名とパスワードを受け取る
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		UserDAO userDaoObj = new UserDAO();
		User user = null;
		user = userDaoObj.selectByUser(id,password);

		// 入力したデータが一致してるか判定する
		if(id.equals(user.getUserid()) && password.equals(user.getPassword())) {

			// メニュー画面に遷移する
			request.getRequestDispatcher("/view/user/menu.jsp").forward(request, response);

		// 入力したデータが間違ってたらログイン画面のまま
		}else {
			request.getRequestDispatcher("/view/user/login.jsp").forward(request, response);
		}

	}

}
