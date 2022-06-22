/*
 * プログラム名：入金・配送の更新プログラム
 * プログラムの説明：
 * 作成者：山口柊耶
 * 作成日：6月21日
 */

package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Order;
import dao.OrderDAO;

public class StatusUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// String error = "";
		String cmd = "";

		try {

			// AdminDAOクラスのオブジェクト生成
			OrderDAO objDao = new OrderDAO();

			// 入金・配送状況更新後の情報を格納するオブジェクト生成
			Order order = new Order();

			// 画面からの入力情報を受け取るためのエンコードを設定➾文字化けしないため
			request.setCharacterEncoding("UTF-8");

			//画面から送信されるcmdの値を取得➾update.jspの60行台
			cmd = request.getParameter("cmd");//cmdにlistが入っている

			/*
			 * 画面（update.jsp）のラジオボタン入力による情報を受け取り name属性で設定した2つの値（payment,delivery）と一致させる
			 * ➾orderに格納
			 */
			//
			if(cmd.equals("list")) {
				order.setPayment(request.getParameter("payment"));
				order.setDelivery(request.getParameter("delivery"));
				objDao.update(order);
			}else if (cmd.equals("update")) {
				order = objDao.selectByOrderid(order.getOrderid());
				request.setAttribute("order",order);

			}


		} catch (IllegalStateException e) {

		} finally {
			// cmdの値で遷移先を判断
			if (cmd.equals("list")) {
				request.getRequestDispatcher("/orderlist").forward(request, response);
			}

			if (cmd.equals("update")) {
				request.getRequestDispatcher("/view/admin/update.jsp").forward(request, response);
			}//エラー処理はここからelseで遷移させる？

		}

	}

}
