package machine;

public class Coffee {
    /*
    For one espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans.
    It costs $4.
    For a latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans.
    It costs $7.
    And for a cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans.
    It costs $6.
     */

    private int water = 0;
    private int milk = 0;
    private int beans = 0;
    private int cost = 0;

    Coffee(String name) {
        switch (name) {
            case "espresso":
                this.water = 250;
                this.beans = 16;
                this.cost = 4;
                break;
            case "latte":
                this.water = 350;
                this.milk = 75;
                this.beans = 20;
                this.cost = 7;
                break;
            case "cappuccino":
                this.water = 200;
                this.milk = 100;
                this.beans = 12;
                this.cost = 6;
                break;
            default:
                break;
        }
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    public int getCost() {
        return cost;
    }
}
