import java.util.ArrayList;

public class VendingMachine {
    private ArrayList<Item> items;
    private double money;
    private int color;
    private static int BLUE = 0;
    private static int RED = 1;
    private static int YELLOW = 2;
    private static int GREEN = 3;

    public VendingMachine() {
        money = 0;
        color = BLUE;
        items = new ArrayList<>();
    }

    public VendingMachine(ArrayList<Item> items){
        this.color = RED;
        this.items = items;
        money = 0;
    }

    public VendingMachine(ArrayList<Item> items, int color){
        this.color = color;
        this.items = items;
        money = 0;
    }

    public VendingMachine(Item item1, Item item2, Item item3, Item item4, Item item5, Item item6, int color){
        this.color = color;
        items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        money = 0;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(int index) {
        items.remove(index);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public boolean updateItem(int firstIndex, Item newItem){
        items.set(firstIndex, newItem);
        return true;
    }

    public boolean updateItem(Item firstItem, Item newItem){
        for(int i = 0; i < items.size(); i++){
            if(firstItem == items.get(i)){
                items.set(i, newItem);
                return true;
            }
        }

        return false;
    }


    public ArrayList<Item> getItems(){
        return this.items;
    }

    public void setItems(ArrayList<Item> items){
        this.items = items;
    }

    public Item getItem(int index) {
        return items.get(index);
    }

    public Item getItem(String name){
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getName() == name){
                return items.get(i);
            }
        }

        return null;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public double getTotalMoney(){
        return money;
    }

    public void setTotalMoney(double amt){
        this.money = amt;
    }

    public void restockItem(Item item, int amt){
        for(int i = 0; i < items.size(); i++){
            if(items.get(i) == item){
                items.get(i).setAmount(amt);
            }
        }
    }

    public void restockAll(int amt){
        for(int i = 0; i < items.size(); i++){
            items.get(i).setAmount(amt);
        }
    }

    public boolean purchaseItem(Item item){
        for(int i = 0; i < items.size(); i++){
            Item temp = items.get(i);
            if(temp == item){
                if(temp.getAmount() > 0) {
                    temp.setAmount(temp.getAmount() - 1);
                    money += temp.getCost();
                    return true; // deposit item
                }
            }
        }
        return false;
    }

    public boolean purchaseItem(int index){
        Item temp = items.get(index);
        if(temp.getAmount() > 0) {
            temp.setAmount(temp.getAmount() - 1);
            money += temp.getCost();

            return true; // deposit item
        }
        return false;
    }

    public void displayItems(){
        for (int i = 0; i < items.size(); i++) {
            // show sold out if not in machine
            System.out.println((i+1) + ") " + items.get(i).getName() + ": " + items.get(i).getCost() + " - " + items.get(i).getAmount() + " Available");
        }
    }

}
