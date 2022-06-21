package bean;

//注文情報を一つのオブジェクトとしてまとめるためのDTOクラス
public class Order {

	private String orderid;		// 注文データのID
	private String userid;		// ユーザーID
	private String name;// 注文者氏名
	private String productid;	// 注文商品ID
	private int quantity;	// 注文個数
	private int sumprice;	// 注文合計
	private String orderday;		// 注文日
	private String address;		// 住所
	private String mail;	// メールアドレス
	private String payment;		// 入金状況
	private String delivery;	// 配送状況

	public Order() {
		this.orderid = null;
		this.userid = null;
		this.name = null;
		this.productid = null;
		this.quantity = 0;
		this.sumprice = 0;
		this.orderday = null;
		this.address = null;
		this.mail = null;
		this.payment = null;
		this.delivery = null;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSumprice() {
		return sumprice;
	}

	public void setSumprice(int sumprice) {
		this.sumprice = sumprice;
	}

	public String getOrderday() {
		return orderday;
	}

	public void setOrderday(String orderday) {
		this.orderday = orderday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

}
