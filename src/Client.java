import java.util.ArrayList;

public class Client {


    public static void main(String args[]){
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Chips", 1.50, 10));
        VendingMachine machine = new VendingMachine();
        
        System.out.println("Enter the number for the object you would like to purchase");
    }
}
