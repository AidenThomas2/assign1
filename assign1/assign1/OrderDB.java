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
			while (line != null) // loop through the entire file
				{
					String[] entries = line.split(","); // split into an array
					Order orders = new Order(Integer.parseInt(entries[0]),entries[1],entries[2],Double.parseDouble(entries[3]), entries[4]);// put the entries into an object
					ordersArr[ords] = orders;
					ords++; // increment the row
					line = ordersFile.readLine(); // read another line
				} // end of while loop
				
				ordersFile.close();
				return ords;
			}
		catch (IOException e) 
			{
				System.out.println(e.getMessage());
			}
		return -1; // No orders loaded
	}
	
	/*public int saveOrders(String fileName) {
		try {
			BufferedWriter writeOrders = new BufferedWriter(new FileWriter(fileName));
			writeOrders.write("Order_ID,Customer_Name,Product,Total_Amt,Order_Date\n");
			int rows = 0;
			for (int i = 0; i < ordersArr.length; i++) {
				writeOrders.write(String.format("%d,%s,%s,%.2f,%s", 
						Integer.parseInt(ordersArr[i][0]), 
						ordersArr[i][1], 
						ordersArr[i][2],
						Double.parseDouble(ordersArr[i][3]),
						ordersArr[i][4]));
				writeOrders.newLine();
				rows++;
			}
			writeOrders.close();
			return rows;
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return -1; 
	}*/
	
	
	public void showOrders() {
		System.out.printf("%-10s %-30s %-10s\n", "Order ID", "Product", "Total Amt" );
		System.out.printf("%-10s %-30s %-10s\n", "--------", "----------", "----------" );
		for (int i = 0; i < ordersArr.length; i+=5) {
			System.out.printf("%-10s %-30s $%-10s\n", ordersArr[i], ordersArr[i+2], ordersArr[i+3]);
		}
	}
	
	/*public boolean add(Order order) {
		String[][] newArr = new String[5][(ordersArr[0].length) + 1];
		newArr = ordersArr;
		int rows = 0;
		for (int i = 0; i < ordersArr[rows].length; i++) {
			//newArr[][rows] = order;
		}
	}*/

}
