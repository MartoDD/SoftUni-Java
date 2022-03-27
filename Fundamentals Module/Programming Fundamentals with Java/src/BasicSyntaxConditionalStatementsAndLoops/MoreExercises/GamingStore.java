package BasicSyntaxConditionalStatementsAndLoops.MoreExercises;

import java.util.Scanner;

public class GamingStore {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double balance = Double.parseDouble(scanner.nextLine());
        double cost = 0;
        double sum = 0;
        boolean notFound = false;
        double endBalance = balance;

        String game = scanner.nextLine();

        while (!game.equals("Game Time")) {

            switch (game) {
                case "OutFall 4":
                    cost = 39.99;
                    break;
                case "CS: OG":
                    cost = 15.99;
                    break;
                case "Zplinter Zell":
                    cost = 19.99;
                    break;
                case "Honored 2":
                    cost = 59.99;
                    break;
                case "RoverWatch":
                    cost = 29.99;
                    break;
                case "RoverWatch Origins Edition":
                    cost = 39.99;
                    break;
                default:
                    System.out.println("Not Found");
                    notFound = true;
                    break;
            }
            if ((sum + cost) > balance) {
                System.out.println("Too Expensive");
            } else {
                if (!notFound) {
                    System.out.printf("Bought %s%n", game);
                    sum += cost;
                    endBalance -= cost;

                }
            }
            notFound = false;

            if (endBalance == 0) {
                System.out.println("Out of money!");
                break;
            }

            game = scanner.nextLine();
        }
        if (game.equals("Game Time")) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", sum, endBalance);
        }
    }
}
