package assign1;

public class Order {
	private int orderID;
	private String custName;
	private String product;
	private double price;
	private String date;
	
	public Order() {
		this.date = "0/0/0";
	}
	
	public Order(int id, String name, String product, double price, String date) {
		orderID = id;
		custName = name;
		this.product = product;
		this.price = price;
		this.date = date;
	}
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
