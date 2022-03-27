package ConditionalStatements.Excersises;

import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double movieBudget = scanner.nextDouble();
        int extras = scanner.nextInt();
        double priceCostume = scanner.nextDouble();
        double decorPrice = movieBudget * 0.1;
        double  priceExtras = priceCostume * extras;


        if (extras >150) {
            priceExtras *= 0.9;
        }
        double totalExpenses = priceExtras + decorPrice;

        if (movieBudget >= totalExpenses) {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", movieBudget - totalExpenses);
        }else {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", totalExpenses - movieBudget);
        }
    }
}
