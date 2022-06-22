package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.UserDAO;

public class UserUpdateServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userid = "";
		String name = "";
		String mail = "";
		String address = "";
		String error = "";
		String cmd = "";

		try {

			// 画面からの入力情報を受け取るためのエンコードを設定
			request.setCharacterEncoding("UTF-8");

			// 更新後の会員情報を格納するBookオブジェクトを生成
			User userInfo = new User();

			// DAOオブジェクト宣言
			UserDAO userDao = new UserDAO();

			//getAttributeメソッドからセッションコープに登録したuserInfoを取得
			HttpSession session = request.getSession();
			User oldUserInfo =(User)session.getAttribute("userInfo");

			//会員IDを取得
			userid = oldUserInfo.getUserid();

			// 画面からの入力情報を受け取る
			name = request.getParameter("name");
			mail = request.getParameter("email");
			address = request.getParameter("address");



			// エラー処理--------------------------------------------------------------------------------
			// 未入力判定
			// 氏名
			//if ("".equals(name)) {
			//	error = "nameが未入力の為、会員情報変更は行えませんでした。";
			//	cmd = "list";
			//	return;
			//}
			// メール
			//if ("".equals(mail)) {
			//	error = "mailが未入力の為、会員情報変更は行えませんでした。";
			//	cmd = "list";
			//	return;
			//}
			//住所
			//if ("".equals(address)) {
			//	error = "addressが未入力の為、会員情報変更は行えませんでした。";
			//	cmd = "list";
			//	return;
			//}

			// 更新対象の会員情報が存在しているかselectByUserIdメソッドでチェック
			//User check = new User();
			//check = userDao.selectByUserId(userid);

			//if (check.getUserid() == null) {
			//	error = "更新対象の会員情報が存在しない為、会員情報変更は行えませんでした。";
			//	cmd = "list";
			//	return;
			//}
			// ---------------------------------------------------------------------------------

			// 各setterメソッドを利用し、userid, name, mail,address,passwordを設定
			userInfo.setUserid(userid);
			userInfo.setName(name);
			userInfo.setMail(mail);
			userInfo.setAddress(address);

			// UserDAOクラスに定義したupdate（）メソッドを利用して、会員情報を更新
			userDao.update(userInfo);

			//selectByUserIdメソッドで呼び出し
			userInfo  = userDao.selectByUserId(userInfo.getUserid());

			//更新後の会員情報をセッションスコープに登録
			session.setAttribute("userInfo", userInfo);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、会員情報変更は行えませんでした。";
			cmd = "menu";
			return;
		} catch (Exception e) {
			error = "予期せぬエラーが発生しました。<br>" + e;
		} finally {
			//request.setAttribute("error", error);
			if ("".equals(error)) {
				request.getRequestDispatcher("/view/user/menu.jsp").forward(request, response);
			} else {
				// errorとcmdをリクエストスコープに登録し、error.jspにフォワード
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
