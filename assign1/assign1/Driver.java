package assign1;
import java.util.Scanner;
public class Driver {

	public static void main(String[] args) {
		OrderDB o = new OrderDB();
		o.loadOrders("orders.txt");
		System.out.println("***************************");
		System.out.println("**** Size and Capacity ****");
		System.out.println(o.size());
		System.out.println(o.capacity());
		o.showOrders();
		System.out.println("*****************************");
		System.out.println("**** Cleared and Resized ****");
		o.clear();
		o.resize();
		System.out.println(o.size());
		System.out.println(o.capacity());
		o.loadOrders("orders.txt");
		Order ord1 = new Order(2123, "Aiden Thomas", "Standing Desk", 90.23, "20/21/26");
		o.add(ord1);
		o.add(34, new Order(1992, "John Travolta", "Record Label", 110.02, "4/19/1999"));
		o.showOrders();
		System.out.println("***************************");
		System.out.println("**** Size and Capacity ****");
		System.out.println(o.size());
		System.out.println(o.capacity());
		o.remove(27);
		o.showOrders();
		System.out.println("***************************");
		System.out.println("**** Size and Capacity ****");
		System.out.println(o.size());
		System.out.println(o.capacity());
		Order ord2 = new Order(7832, "Neil DeGrasse Tyson", "The Sun", 9999.0, "10/22/2023");
		o.set(0, ord2);
		o.showOrders();
		System.out.println("***************************");
		System.out.println("**** Size and Capacity ****");
		System.out.println(o.size());
		System.out.println(o.capacity());
		Order ord3 = o.get(0);
		o.clear();
		o.loadOrders("orders.txt");
		o.add(0, ord3);
		o.showOrders();
		Scanner io = new Scanner(System.in);
		System.out.println("Please enter an ID!");
		int index = io.nextInt();
		System.out.println("This is the index where your ID is at: " + o.searchByOrderID(index));
		o.saveOrders("savedOrders.txt");
		System.out.println("Saved current orders to savedOrders.txt!");
	}

}
