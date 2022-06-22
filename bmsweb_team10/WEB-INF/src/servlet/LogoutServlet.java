package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String cmd = "";
		//セッションオブジェクトの生成
		HttpSession session = request.getSession();

		//セッションデータの破棄
		session.invalidate();

		cmd = request.getParameter("cmd");

		request.setAttribute("error", "ログアウトしました");

		//フォワード
		if(cmd.equals("userlogin")) {
			request.getRequestDispatcher("/view/user/login.jsp").forward(request, response);
		}else if(cmd.equals("adminlogin")) {
			request.getRequestDispatcher("/view/admin/login.jsp").forward(request, response);
		}

	}

}