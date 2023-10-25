package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int cups;
    public static void main(String[] args) {
        boolean start = true;
        Scanner scanner = new Scanner(System.in);
        String choice;
        //Machine machine = new Machine();
        //At the moment, the coffee machine has
        // $550, 400 ml of water, 540 ml of milk, 120 g of coffee beans, and 9 disposable cups.
        Machine machine = new Machine(400,540,120,9,550);
        machine.initMachineProcedures();
        machine.machineState();

        while (start) {
            System.out.println("Write action (buy, fill, take):");
            choice = scanner.nextLine();

            switch (choice) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    int option = scanner.nextInt();
                    if (option == 1 || option == 2 || option == 3)
                        machine.buyCoffee(option);
                    else
                        System.out.println("Choose the correct option!");
                    break;
                case "fill":
                    machine.fillMachine();
                    break;
                case "take":
                    machine.take();
                    break;
                case "exit":
                    start = false;
                    break;
                default:
                    break;
            }
        }
        //machine.getMachineProcedures().forEach(procedure-> System.out.println(procedure.toString()));
        //machine.calculateIngredients();

    }
}
