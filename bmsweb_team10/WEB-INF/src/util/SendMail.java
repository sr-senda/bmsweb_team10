package util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Date;
import java.util.Properties;
import bean.Order;
import bean.Product;

public class SendMail {

	// 商品を購入した時に自動でメールを送るメソッド
	public void OrderMail(Order order, Product product){
		try {
			Properties props = System.getProperties();

			// SMTPサーバのアドレスを指定（今回はxserverのSMTPサーバを利用）
			props.put("mail.smtp.host", "sv5215.xserver.jp");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.debug", "true");

			Session session = Session.getInstance(
				props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						//メールサーバにログインするメールアドレスとパスワードを設定
						return new PasswordAuthentication("system.project.team19@kanda-it-school-system.com", "6Hg4UByxyThvcPK");
					}
				}
			);

			MimeMessage mimeMessage = new MimeMessage(session);

			// 送信元メールアドレスと送信者名を指定
			mimeMessage.setFrom(new InternetAddress("system.project.team19@kanda-it-school-system.com", "神田IT School", "iso-2022-jp"));

			// 送信先メールアドレスを指定
			mimeMessage.setRecipients(Message.RecipientType.TO, order.getMail());


			// メールのタイトルを指定
			mimeMessage.setSubject("◆ご購入手続き完了のお知らせ", "iso-2022-jp");

			// メールの内容を指定
			mimeMessage.setText(order.getName() + "様" + "\n\n" +
								"この度は神田ユニフォームをご利用いただきまして、誠にありがとうございます。" + "\n\n" +
								"▼購入情報の確認はこちら" + "\n" +
								"商品名　 ：" + product.getProductname() + "\n" +
								"価格　　 ：" + product.getPrice() + "円\n" +
								"個数　　 ：" + order.getQuantity() + "個\n" +
								"合計　　 ：" + order.getSumprice() +"円\n\n" +
								"▼振込先についてはこちら" + "\n" +
								"お支払い方法：○○○○" + "\n\n" +
								"■お問い合わせはこちらからお願いします。\n" +
								"URL-https://○○○", "iso-2022-jp");

			// メールの形式を指定
			mimeMessage.setHeader("Content-Type", "text/plain; charset=iso-2022-jp");

			// 送信日付を指定
			mimeMessage.setSentDate(new Date());

			// 送信します
			Transport.send(mimeMessage);

			// 送信成功
			System.out.println("送信に成功しました。");

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("送信に失敗しました。\n" + e);
		}
	}

	// 入金確認ボタンを押したら送信される
	public void PaymentMail(Order order){
		try {
			Properties props = System.getProperties();

			// SMTPサーバのアドレスを指定（今回はxserverのSMTPサーバを利用）
			props.put("mail.smtp.host", "sv5215.xserver.jp");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.debug", "true");

			Session session = Session.getInstance(
				props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						//メールサーバにログインするメールアドレスとパスワードを設定
						return new PasswordAuthentication("system.project.team19@kanda-it-school-system.com", "6Hg4UByxyThvcPK");
					}
				}
			);

			MimeMessage mimeMessage = new MimeMessage(session);

			// 送信元メールアドレスと送信者名を指定
			mimeMessage.setFrom(new InternetAddress("system.project.team19@kanda-it-school-system.com", "神田IT School", "iso-2022-jp"));

			// 送信先メールアドレスを指定（お客様のメールアドレスに変更はまだしてません）
			mimeMessage.setRecipients(Message.RecipientType.TO, order.getMail());


			// メールのタイトルを指定
			mimeMessage.setSubject("◆ご入金確認のお知らせ", "iso-2022-jp");

			// メールの内容を指定
			mimeMessage.setText(order.getName() + "様\n"
					+ "この度は神田ユニフォームをご利用いただきまして、誠にありがとうございます。\n\n"
					+ "ご入金の確認が取れましたので、発送の準備が整い次第、発送いたします。\n"
					+ "発送が完了しましたら改めてご連絡いたしますので、どうぞよろしくお願いいたします。\n\n"
					+ "■お問い合わせはこちらからお願いします。\n"
					+ "URL-https://○○○", "iso-2022-jp");

			// メールの形式を指定
			mimeMessage.setHeader("Content-Type", "text/plain; charset=iso-2022-jp");

			// 送信日付を指定
			mimeMessage.setSentDate(new Date());

			// 送信します
			Transport.send(mimeMessage);

			// 送信成功
			System.out.println("送信に成功しました。");

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("送信に失敗しました。\n" + e);
		}
	}

	// 発送完了したらメールを送る
	public void DeliveryMail(Order order){
		try {
			Properties props = System.getProperties();

			// SMTPサーバのアドレスを指定（今回はxserverのSMTPサーバを利用）
			props.put("mail.smtp.host", "sv5215.xserver.jp");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.debug", "true");

			Session session = Session.getInstance(
				props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						//メールサーバにログインするメールアドレスとパスワードを設定
						return new PasswordAuthentication("system.project.team19@kanda-it-school-system.com", "6Hg4UByxyThvcPK");
					}
				}
			);

			MimeMessage mimeMessage = new MimeMessage(session);

			// 送信元メールアドレスと送信者名を指定
			mimeMessage.setFrom(new InternetAddress("system.project.team19@kanda-it-school-system.com", "神田IT School", "iso-2022-jp"));

			// 送信先メールアドレスを指定
			mimeMessage.setRecipients(Message.RecipientType.TO, order.getMail());


			// メールのタイトルを指定
			mimeMessage.setSubject("◆商品発送のお知らせ", "iso-2022-jp");

			// メールの内容を指定
			mimeMessage.setText(order.getName() + "様\n"
					+ "商品を発送いたしました。\n\n"
					+ "到着までもうしばらくお待ちください。\n\n"
					+ "この度は神田ユニフォームをご利用いただきまして、誠にありがとうございました。\n\n"
					+ "■お問い合わせはこちらからお願いします。\n"
					+ "URL-https://○○○", "iso-2022-jp");

			// メールの形式を指定
			mimeMessage.setHeader("Content-Type", "text/plain; charset=iso-2022-jp");

			// 送信日付を指定
			mimeMessage.setSentDate(new Date());

			// 送信します
			Transport.send(mimeMessage);

			// 送信成功
			System.out.println("送信に成功しました。");

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("送信に失敗しました。\n" + e);
		}
	}
}