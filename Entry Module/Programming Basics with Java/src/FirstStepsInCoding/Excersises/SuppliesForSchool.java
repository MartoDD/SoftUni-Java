package FirstStepsInCoding.Excersises;

import java.util.Scanner;

public class SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double pen = Double.parseDouble(scanner.nextLine()) * 5.80;
        double markers = Double.parseDouble(scanner.nextLine()) * 7.20;
        double boardCleaner = Double.parseDouble(scanner.nextLine()) * 1.20;
        double discount = Double.parseDouble(scanner.nextLine()) / 100;
        double totalPrice = (pen + markers + boardCleaner);
        double totalPriceDiscount = totalPrice - (totalPrice * discount);
        System.out.println(totalPriceDiscount);

    }
}
