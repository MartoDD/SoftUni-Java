package FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class Fishland {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceFishS = Double.parseDouble(scanner.nextLine());
        double priceFishT = Double.parseDouble(scanner.nextLine());
        double kilogramP = Double.parseDouble(scanner.nextLine());
        double kilogramSa = Double.parseDouble(scanner.nextLine());
        int kilogramMuscles = Integer.parseInt(scanner.nextLine());

        double priceP = priceFishS * 1.6 * kilogramP;
        double priceSa = priceFishT * 1.8 * kilogramSa;
        double priceMuscles = kilogramMuscles * 7.50;

        double total = priceP + priceSa + priceMuscles;

        System.out.printf("%.2f", total);



    }
}
