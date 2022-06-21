package servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.User;
import dao.UserDAO;

//メモ
//エラー後の画面遷移先未指定
//cmdの機能の有無の確認

public class UserRegisterServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		String userid = "";
		String name = "";
		String mail = "";
		String address = "";
		String password = "";
		String error = "";
		String cmd = "";

		try {

			// 画面からの入力情報を受け取るためのエンコードを設定
			request.setCharacterEncoding("UTF-8");

			// 登録するための会員情報を格納するUserオブジェクトを定義
			User userInfo = new User();

			// 画面からの入力情報を受け取る
			userid = request.getParameter("id");
			name = request.getParameter("name");
			mail = request.getParameter("email");
			address = request.getParameter("address");
			password = request.getParameter("password");

			// DAOオブジェクト宣言
			UserDAO userDao = new UserDAO();

			// エラー処理--------------------------------------------------------------------------------
			// 未入力判定
			// 会員ID
			//if ("".equals(userid)) {
			//	error = "useridが未入力の為、会員登録は行えませんでした。";
			//	cmd = "list";
			//	return;
			//}
			// 氏名
			//if ("".equals(name)) {
			//	error = "nameが未入力の為、会員登録は行えませんでした。";
			//	cmd = "list";
			//	return;
			//}
			// メール
			//if ("".equals(mail)) {
			//	error = "mailが未入力の為、会員登録は行えませんでした。";
			//	cmd = "list";
			//	return;
			//}
			//住所
			//if ("".equals(address)) {
			//	error = "addressが未入力の為、会員登録は行えませんでした。";
			//	cmd = "list";
			//	return;
			//}
			//パスワード
			//if ("".equals(password)) {
			//	error = "passwordが未入力の為、会員登録は行えませんでした。";
			//	cmd = "list";
			//	return;
			//}

			// User型のオブジェクトcheckを生成し、selectByUserメソッドを利用し重複チェックをおこなう
			//User check = new User();
			//check = userDao.selectByUserId(userid);

			// もし重複していたら、下記のとおりerrorに代入する
			//if (check.getUserid() != null) {
			//	error = "入力した会員IDは既に登録済みの為、会員登録は行えませんでした。";
				// エラーメッセージとは別の情報としてcmd情報を送る
			//	cmd = "list";
			//	return;
			//}
			//--------------------------------------------------------------------------------------------

			// 各setterメソッドを利用し、userid, name, mail,address,passwordを設定
			userInfo.setUserid(userid);
			userInfo.setName(name);
			userInfo.setMail(mail);
			userInfo.setAddress(address);
			userInfo.setPassword(password);

			// insert（）メソッドを利用して、Userオブジェクトに格納された書籍データをデータベースに登録
			userDao.insert(userInfo);

			//Userオブジェクトをセッションスコープに"userInfo"という名前で登録
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", userInfo);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、会員登録はできませんでした。";
			cmd = "menu";
			return;
		} catch (Exception e) {
			error = "予期せぬエラーが発生しました。<br>" + e;
		} finally {
			//request.setAttribute("error", error);
			if ("".equals(error)) {
				request.getRequestDispatcher("/view/user/menu.jsp").forward(request, response);
			} else {
				//errorとcmdをリクエストスコープに登録し、error.jspにフォワード
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/user/userRegister.jsp").forward(request, response);
			}
		}
	}
}
