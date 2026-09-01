package assign1;

public class Driver {

	public static void main(String[] args) {
		OrderDB o = new OrderDB();
		
		o.loadOrders("orders.txt");
		o.saveOrders("testorder.txt");
		o.showOrders();
	}

}
