import java.util.ArrayList;
import java.util.Scanner;

public class Client {


    public static void main(String args[]){
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Chips", 1.50, 10));
        items.add(new Item("Cookies", 2.00, 5));
        VendingMachine machine = new VendingMachine(items);
        machine.addItem(new Item("Soda", 2.75, 15));

        while(true) {
            System.out.println("Enter the number for the object you would like to purchase");
            machine.displayItems();
            System.out.println("-1) Exit");

            Scanner in = new Scanner(System.in);
            int num = in.nextInt();

            if (num < 0) {
                break;
            } else if (num <= items.size()) {
                machine.purchaseItem(num - 1);
            }
        }
    }
}
