package WhileLoop.MoreExcersises;

import java.util.Scanner;

public class Dishwasher {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()) * 750;
        int quantity;
        String input = scanner.nextLine();
        int totalForWash;
        int counter = 0;
        int sum = 0;
        boolean willBeEnough = true;
        int counterPlates = 0;
        int counterPots = 0;

        while (!input.equals("End")) {
            quantity = Integer.parseInt(input);
            counter++;
            if (counter % 3 == 0) {
                counterPots += quantity;
                totalForWash = quantity * 15;
            } else {
                totalForWash = quantity * 5;
                counterPlates += quantity;
            }
            sum += totalForWash;

            if (sum > n) {
                willBeEnough = false;
                break;
            }

            input = scanner.nextLine();
        }
        if (willBeEnough) {
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.%n", counterPlates, counterPots);
            System.out.printf("Leftover detergent %d ml.", n - sum);
        } else {
            System.out.printf("Not enough detergent, %d ml. more necessary!", Math.abs(sum - n));
        }

    }
}
