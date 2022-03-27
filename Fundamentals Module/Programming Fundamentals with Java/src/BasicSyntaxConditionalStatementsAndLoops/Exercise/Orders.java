package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class Orders {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0;

        for (int i = 1; i <= n; i++) {

            double priceCaps = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsCount = Integer.parseInt(scanner.nextLine());
            double coffee = ((days * capsCount) * priceCaps);

            System.out.printf("The price for the coffee is: $%.2f%n", coffee);
            totalPrice += coffee;
        }
        System.out.printf("Total: $%.2f", totalPrice);
    }
}
