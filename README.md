## CSCE 20003 Data Structures Pre-Assessment

## Instructions

Using the starter Eclipse Project, implement the provided interface, **OrderDBInterface.java**.  Name your implementation **OrderDB**. And test your implementation with a separate **Driver.java** program.  The orders text file (**orders.txt**) contains the 50 example orders with a header record at the top of the file. Create an **Order.java** class that describes an Order record from the text file. *The initial size of your Array should be 25.*  

```java
package dsPreAssess;

public interface OrderDBInterface {
    int loadOrders(String fileName);    //Loads the orders into the array from the specified file. Returns the number of orders loaded.
    int saveOrders(String fileName);    //Saves the orders from the array in the specified file. Returns the number of records written.
    void showOrders();                  //Display the Orders from the File
    boolean add(Order order);            //Add order to the End of the array. Returns true if successful.
    void add(int index, Order order);    //Inserts the order at the specified position in this array.
    void clear();                        //Removes all orders
    Order get(int index);                //Returns the order at the specified position in the array
    int searchByOrderID(int orderID);    //Returns the location of the order with the specified orderID in the array.  Returns -1 if not found.
    Order remove(int index);             //Removes the order at the specified position in the array. Returns the removed order.
    Order set(int index, Order order);   //Replaces the order at the specified position in the array with with the new order.  Returns the order that was replaced
    int size();                          //Returns the number of orders in the array
    int capacity();                      //Returns the allocated size of the array.  
    void resize();                       //Resize the Array by 25 additional elements.
}
```
The **loadOrders()** should load the file contents into an **Array(Not an ArrayList**). The display output created from your **showOrders()** implementation should look EXACTLY like the following:

```
Order ID Product                         Total Amt
-------- -------                         ---------
1001     Mechanical Keyboard                263.42
1002     Mechanical Keyboard                220.60
1003     Mechanical Keyboard                185.88
1004     HD Monitor 27                      777.70
1005     Wireless Mouse                     497.76
1006     HD Monitor 27                      147.72
1007     Noise Canceling Headphones         518.05
1008     Mechanical Keyboard                165.60
1009     Noise Canceling Headphones         397.10
1010     HD Monitor 27                     1035.15
1011     Mechanical Keyboard                432.48
1012     Noise Canceling Headphones         255.54
1013     USB-C Hub                         1296.30
```

You may create any additional classes, if you need, but your **OrderDB** must implement the **OrderDBInterface**.  You cannot change the interface.
