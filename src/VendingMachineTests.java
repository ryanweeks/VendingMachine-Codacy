import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendingMachineTests {
    ArrayList<Item> items = new ArrayList<>();
    VendingMachine machine;

    @BeforeEach()
    void setup(){
        items.add(new Item("Chips", 1.50, 10));
        items.add(new Item("Cookies", 2.00, 5));
        machine = new VendingMachine(items);
    }

    @Test
    void TestAddItem(){
        Item tempItem = new Item("Soda", 2.75, 15);
        machine.addItem(tempItem);
        Item actual = machine.getItem(2);
        assertEquals(tempItem, actual);
    }

    @Test
    void TestPurchaseItemCostIncreased(){
        machine.purchaseItem(1);
        double actual = machine.getTotalMoney();
        double expected = 2.00;
        assertEquals(expected, actual);
    }

    @Test
    void TestPurchaseItemAmountDecreased(){
        machine.purchaseItem(1);
        int actual = machine.getItem(1).getAmount();
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void TestRestockAll(){
        machine.restockAll(2);
        int actual = machine.getItem(1).getAmount();
        int expected = 2;
        assertEquals(expected, actual);
    }


}
