package assign1;

public class Driver {

	public static void main(String[] args) {
		OrderDB o = new OrderDB();
		
		o.loadOrders("orders.txt");
		o.showOrders();
		o.add(12, new Order(1234, "John", "Stapler", 22.34, "10/10/10"));
		o.showOrders();
	}

}
