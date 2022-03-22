package FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class VegetableMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceVeg = Double.parseDouble(scanner.nextLine());
        double priceFr = Double.parseDouble(scanner.nextLine());
        double kgVeg = Double.parseDouble(scanner.nextLine());
        double kgFr = Double.parseDouble(scanner.nextLine());

        double total = kgVeg * priceVeg + kgFr * priceFr;
        double totalEu = total / 1.94;

        System.out.printf("%.2f", totalEu);

    }
}
