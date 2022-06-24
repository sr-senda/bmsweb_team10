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
import util.SendMail;

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

			// 画面から送信されるcmdの値を取得➾update.jspの60行台
			cmd = request.getParameter("cmd");// cmdにlistが入っている

			if (cmd.equals("list")) {
				order.setOrderid(request.getParameter("orderid"));
				order.setPayment(request.getParameter("payment"));
				order.setDelivery(request.getParameter("delivery"));
				objDao.update(order);
			} else if (cmd.equals("update")) {
				String orderid = request.getParameter("orderid");
				order = objDao.selectByOrderid(orderid);
				request.setAttribute("order", order);

				String payment = request.getParameter("payment");
				String delivery = request.getParameter("delivery");

				// 入金済み且つ未発送ならメールを送る
				if(payment.equals("2") && delivery.equals("1")) {
					SendMail sendMail = new SendMail();
					sendMail.PaymentMail(order);
				}

				// 入金済み且つ発送済みならメールを送る
				if(payment.equals("2") && delivery.equals("3")) {
					order.getName();
					SendMail sendMail = new SendMail();
					sendMail.DeliveryMail(order);
				}

			}

		} catch (IllegalStateException e) {

		} finally {
			// cmdの値で遷移先を判断
			if (cmd.equals("list")) {
				request.getRequestDispatcher("/orderlist").forward(request, response);
			}

			if (cmd.equals("update")) {
				request.getRequestDispatcher("/view/admin/update.jsp").forward(request, response);
			} // エラー処理はここからelseで遷移させる？

		}

	}

}
