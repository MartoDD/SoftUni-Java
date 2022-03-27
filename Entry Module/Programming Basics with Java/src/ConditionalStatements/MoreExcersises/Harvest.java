package ConditionalStatements.MoreExcersises;

import java.util.Scanner;

public class Harvest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int area = scanner.nextInt();
        double grapePerArea = scanner.nextDouble();
        int neededWine = scanner.nextInt();
        int workers = scanner.nextInt();

        double grapeForWine = (area * grapePerArea) * 0.40;
        double wineLiters = grapeForWine / 2.50;
        double remainingWine;
        double workerWine;
        double moreWineNeeded;

        if (wineLiters >= neededWine) {
            remainingWine = Math.ceil(wineLiters - neededWine);
            workerWine = Math.ceil(remainingWine / workers);
            wineLiters = Math.floor(wineLiters);

            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n%.0f liters left -> %.0f liters per person.", wineLiters, remainingWine, workerWine);
        } else {
            moreWineNeeded = Math.floor(neededWine - wineLiters);
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", moreWineNeeded);
        }
    }
}
