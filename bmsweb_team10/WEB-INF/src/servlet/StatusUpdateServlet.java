/*
 * プログラム名：入金・配送の更新プログラム
 * プログラムの説明：
 * 作成者：山口柊耶
 * 作成日：6月21日
 */

package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Order;
import dao.AdminDAO;

public class StatusUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			// AdminDAOクラスのオブジェクト生成
			AdminDAO objDao = new AdminDAO();

			// 入金・配送状況更新後の情報を格納するオブジェクト生成
			Order order = new Order();

			// 画面からの入力情報を受け取るためのエンコードを設定➾文字化けしないため
			request.setCharacterEncoding("UTF-8");

			/*
			 * 画面（update.jsp）のラジオボタン入力による情報を受け取り name属性で設定した2つの値（payment,delivery）と一致させる
			 * ➾orderに格納
			 */
			order.setPayment(request.getParameter("payment"));
			order.setDelivery(request.getParameter("delivery"));

			// AdminDAOクラスにあるupdateメソッドを利用し、
			// 格納されたorderを引数にDBを更新
			objDao.update(order);

		} catch (IllegalStateException e) {

		}

	}

}
