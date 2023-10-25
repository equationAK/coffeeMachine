package machine;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Machine {

    private int water = 0;
    private int milk = 0;
    private int beans = 0;

    private int disposableCups = 0;

    private int balance = 0;

    private ArrayList<String> machineProcedures = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    Machine (int water, int milk, int beans, int disposableCups, int balance) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.disposableCups = disposableCups;
        this.balance = balance;
    }

    Machine(){};

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    public int getDisposableCups() {
        return disposableCups;
    }

    public int getBalance() {
        return balance;
    }

    public String balanceToString() {
        return ("$" + getBalance()).toString();
    }

    public void setWater(int water) {
        this.water = water;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }

    public void setDisposableCups(int disposableCups) {
        this.disposableCups = disposableCups;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void initMachineProcedures() {
        machineProcedures.add("Starting to make a coffee");
        machineProcedures.add("Grinding coffee beans");
        machineProcedures.add("Boiling water");
        machineProcedures.add("Mixing boiled water with crushed coffee beans");
        machineProcedures.add("Pouring coffee into the cup");
        machineProcedures.add("Pouring some milk into the cup");
        machineProcedures.add("Coffee is ready!");
    }

    public ArrayList<String> getMachineProcedures() {
        return machineProcedures;
    }

    public void calculateIngredients() {
        // 1 cup contains 200 ml of water, 50 ml of milk, 15 g of coffee beans
        int cups;
        int possibleCups = Math.min(Math.min(getWater()/200,getMilk()/50),getBeans()/15);
        System.out.println("Write how many cups of coffee you will need:");
        cups = scanner.nextInt();
        int waterNeeded = cups * 200;
        int milkNeeded = cups * 50;
        int beansNeeded = cups * 15;
        int min = Math.min(Math.min(getWater()/waterNeeded,getMilk()/milkNeeded),getBeans()/beansNeeded);

        if(min == 0)
            System.out.printf("No, I can make only %d cup(s) of coffee\n",possibleCups);
        else if(cups - min == 0)
            System.out.println("Yes, I can make that amount of coffee\n");
        else {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)\n",cups - min);
        }
    }

    public void buyCoffee(int choice) {
        // 1 - espresso, 2 - latte, 3 - cappuccino
        ArrayList<String> choices = new ArrayList<>();
        choices.add("espresso");
        choices.add("latte");
        choices.add("cappuccino");


        Coffee coffee = new Coffee(choices.get(choice - 1));
        setWater(getWater() - coffee.getWater());
        setMilk(getMilk() - coffee.getMilk());
        setBeans(getBeans() - coffee.getBeans());
        setDisposableCups(getDisposableCups() - 1);
        setBalance(getBalance() + coffee.getCost());

        machineState();
    }

    public void fillMachine(){
        System.out.println("Write how many ml of water you want to add:");
        setWater(getWater() + scanner.nextInt());
        System.out.println("Write how many ml of milk you want to add:");
        setMilk(getMilk() + scanner.nextInt());
        System.out.println("Write how many grams of coffee beans you want to add:");
        setBeans(getBeans() + scanner.nextInt());
        System.out.println("Write how many disposable cups you want to add: ");
        setDisposableCups(getDisposableCups() + scanner.nextInt());
        machineState();
    }

    public void take() {
        System.out.printf("I gave you %d\n",balanceToString());
        setBalance(0);
        machineState();
    }

    public void machineState() {
        System.out.printf("The coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money\n\n",getWater(),getMilk(),getBeans(),getDisposableCups(),getBalance());
    }
}
