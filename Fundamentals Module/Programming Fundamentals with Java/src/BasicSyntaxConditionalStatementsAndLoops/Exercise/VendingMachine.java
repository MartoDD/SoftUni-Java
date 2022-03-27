package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class VendingMachine {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double sum = 0;
        double totalPrice = 0;
        double price = 0;
        boolean valid = true;


        while (!input.equals("Start")) {
            double money = Double.parseDouble(input);

            if (money == 0.1 || money == 0.2 || money == 0.5 || money == 1 || money == 2) {
                sum += money;
            } else {
                System.out.printf("Cannot accept %.2f%n", money);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();

        while (!input.equals("End")) {

            switch (input) {
                case "Nuts":
                    price = 2.0;
                    break;
                case "Water":
                    price = 0.7;
                    break;
                case "Crisps":
                    price = 1.5;
                    break;
                case "Soda":
                    price = 0.8;
                    break;
                case "Coke":
                    price = 1.0;
                    break;
                default:
                    System.out.println("Invalid product");
                    valid = false;
                    break;
            }

            totalPrice += price;

            if (totalPrice > sum) {
                System.out.println("Sorry, not enough money");
                totalPrice -= price;
            } else if (valid) {
                System.out.printf("Purchased %s%n", input);
            }
            valid = true;

            input = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", sum - totalPrice);
    }
}
