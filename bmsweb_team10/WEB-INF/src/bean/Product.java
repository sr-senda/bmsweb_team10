package bean;

public class Product {

	private String productid;		// 商品ID
	private String productname;// 商品名
	private int price;	// 価格
	private int stock;	// 在庫

	public Product() {
		this.productid = null;
		this.productname = null;
		this.price = 0;
		this.stock = 0;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
