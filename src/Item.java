public class Item {
    private String name;
    private double cost;
    private int amount;

    public Item(String name, double cost){
        this.name = name;
        this.cost = cost;
        this.amount = 0;
    }

    public Item(String name, double cost, int amount){
        this.name = name;
        this.cost = cost;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
