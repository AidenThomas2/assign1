package assign1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OrderDB implements OrderDBInterface {
	Order[] ordersArr = new Order[25];

	
	public int loadOrders(String fileName) {
		try {
			BufferedReader ordersFile = new BufferedReader(new FileReader(fileName)); // opening file
			ordersFile.readLine(); //get rid of that header
			int ords = 0; // orders
			String line = ordersFile.readLine(); // put the 2nd line after the header into this string
			while (line != null && ords < 25) // loop through the entire file
				{
					String[] entries = line.split(","); // split into an array
					// put the entries into an object
					Order orders = new Order(
							Integer.parseInt(entries[0]), //Order_ID
							entries[1], //Customer Name
							entries[2], //Product
							Double.parseDouble(entries[3]), //Price
							entries[4]); //Date
					ordersArr[ords] = orders; // put the objects into an Order array
					ords++; // increment
					
					line = ordersFile.readLine(); // read another line
				} // end of while loop
				
				ordersFile.close();
				return ords; // Returning the amount of orders saved
			}
		catch (IOException e) 
			{
				System.out.println(e.getMessage());
			}
		return -1; // No orders loaded
	}
	
	public int saveOrders(String fileName) {
		try {
			BufferedWriter writeOrders = new BufferedWriter(new FileWriter(fileName)); //open the file we will write to
			writeOrders.write("Order_ID,Customer_Name,Product,Total_Amt,Order_Date\n"); // Header
			int ords = 0;
			for (int i = 0; i < ordersArr.length; i++) {
				writeOrders.write(String.format("%d,%s,%s,%.2f,%s", 
						ordersArr[i].getOrderID(), 
						ordersArr[i].getCustName(), 
						ordersArr[i].getProduct(),
						ordersArr[i].getPrice(),
						ordersArr[i].getDate()));
				writeOrders.newLine();
				ords++;
			}
			writeOrders.close();
			return ords;
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return -1; 
	}
	
	public void showOrders() {
		System.out.printf("%-10s %-30s %-10s\n", "Order ID", "Product", "Total Amt" );
		System.out.printf("%-10s %-30s %-10s\n", "--------", "----------", "----------" );
		for (int i = 0; i < ordersArr.length; i++) {
			System.out.printf("%-10s %-30s $%-10s\n", ordersArr[i].getOrderID(), ordersArr[i].getProduct(), ordersArr[i].getPrice());
		}
	}
	
	public boolean add(Order order) {
		Order[] tempArrs = new Order[(ordersArr.length)+1];
		for (int i = 0; i < ordersArr.length; i++) {
			tempArrs[i] = ordersArr[i];
		}
		tempArrs[ordersArr.length] = order;
		
		ordersArr = tempArrs;
		
		
		if (ordersArr[(ordersArr.length)-1] == order) {
		return true;	
		} else {
			return false;
		}
	}


	@Override
	public void add(int index, Order order) {
		Order[] tempArrs = new Order[(ordersArr.length)+1];
		for (int i = 0; i < index; i++) {
			tempArrs[i] = ordersArr[i];
		}
		tempArrs[index] = order;
		for (int i = index; i < ordersArr.length ; i++) {
			tempArrs[i + 1] = ordersArr[i];
		}
		
		ordersArr = tempArrs;
	}

	@Override
	public void clear() {
		for (int i = 0; i < ordersArr.length; i++) {
			ordersArr[i] = null;
		}
	}

	@Override
	public Order get(int index) {
		return ordersArr[index];
	}

	@Override
	public int searchByOrderID(int orderID) {
		for (int i = 0; i < ordersArr.length; i++) {
			if (ordersArr[i].getOrderID() == orderID ) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public Order remove(int index) {
		Order[] tempArr = new Order[(ordersArr.length) - 1];
		for (int i = 0; i < index; i++) {
			tempArr[i] = ordersArr[i];
		}
		Order o = new Order();
		o = ordersArr[index];
		for (int i = index+1; i < ordersArr.length; i++) {
			tempArr[i-1] = ordersArr[i];
		}
		ordersArr = tempArr;
		return o;
	}

	@Override
	public Order set(int index, Order order) {
		Order[] tempArr = new Order[ordersArr.length];
		for (int i = 0; i < index; i++) {
			tempArr[i] = ordersArr[i];
		}
		Order o = ordersArr[index];
		tempArr[index] = order;
		for (int i = index + 1; i < ordersArr.length; i++) {
			tempArr[i] = ordersArr[i];
		}
		ordersArr = tempArr;
		return o;
	}

	@Override
	public int size() {
		int size = 0;
		for (int i = 0; i < ordersArr.length; i++) {
			if (ordersArr[i] != null) {
				size++;	
			}
		}
		return size;
	}

	@Override
	public int capacity() {
		return ordersArr.length;
	}

	@Override
	public void resize() {
		Order[] tempArr = new Order[(ordersArr.length)+25];
		for (int i = 0; i < ordersArr.length; i++) {
			tempArr[i] = ordersArr[i];
		}
		ordersArr = tempArr;
	}

}
