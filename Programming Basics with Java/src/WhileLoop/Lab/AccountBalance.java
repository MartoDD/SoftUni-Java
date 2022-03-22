package WhileLoop.Lab;

import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = "";
        double sum = 0;
        while (true) {

            input = scanner.nextLine();

            if (input.equals("NoMoreMoney")) {
                break;
            }
            double number = Double.parseDouble(input);
            if (number < 0) {
                System.out.println("Invalid operation!");
                break;
            } else {
                System.out.printf("Increase: %.2f%n", number);
            }


            sum += number;
        }
        System.out.printf("Total: %.2f", sum);
    }
}
