package assign1;
import java.util.Scanner;
public class Driver {

	public static void main(String[] args) {
		OrderDB o = new OrderDB();
		// Loading orders and checking the size and capacity
		o.loadOrders("orders.txt");
		System.out.println("***************************");
		System.out.println("**** Size and Capacity ****");
		System.out.println(o.size());
		System.out.println(o.capacity());
		o.showOrders();
		System.out.println("*****************************");
		System.out.println("**** Cleared and Resized ****");
		// testing clearing and resizing methods
		o.clear();
		o.resize();
		System.out.println(o.size());
		System.out.println(o.capacity());
		o.loadOrders("orders.txt");
		// testing my add methods
		Order ord1 = new Order(2123, "Aiden Thomas", "Standing Desk", 90.23, "20/21/26");
		o.add(ord1);
		o.add(34, new Order(1992, "John Travolta", "Record Label", 110.02, "4/19/1999"));
		o.showOrders();
		System.out.println("***************************");
		System.out.println("**** Size and Capacity ****");
		System.out.println(o.size());
		System.out.println(o.capacity());
		// testing my remove method
		o.remove(27);
		o.showOrders();
		System.out.println("***************************");
		System.out.println("**** Size and Capacity ****");
		System.out.println(o.size());
		System.out.println(o.capacity());
		// testing replacing orders method
		Order ord2 = new Order(7832, "Neil DeGrasse Tyson", "The Sun", 9999.0, "10/22/2023");
		o.set(0, ord2);
		o.showOrders();
		// testing get method
		System.out.println("***************************");
		System.out.println("**** Size and Capacity ****");
		System.out.println(o.size());
		System.out.println(o.capacity());
		Order ord3 = o.get(0);
		o.clear();
		o.loadOrders("orders.txt");
		// testing add method
		o.add(0, ord3);
		o.showOrders();
		Scanner io = new Scanner(System.in);
		// choose your own id to get the index of!
		System.out.println("Please enter an ID!");
		int index = io.nextInt();
		System.out.println("This is the index where your ID is at index: " + o.searchByOrderID(index));
		//testing saving orders method
		o.saveOrders("savedOrders.txt");
		System.out.println("Saved current orders to savedOrders.txt!");
	}

}
