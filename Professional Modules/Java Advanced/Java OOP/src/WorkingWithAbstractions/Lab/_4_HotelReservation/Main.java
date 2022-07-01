package WorkingWithAbstractions.Lab._4_HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String []input = scanner.nextLine().split("\\s+");

        double pricePerDay=Double.parseDouble(input[0]);
        int numberOfDays=Integer.parseInt(input[1]);
        SeasonMultiplayer season= SeasonMultiplayer.parse(input[2]);
        Discount discount = Discount.parse(input[3]);

        PriceCalculator priceCalculator = new PriceCalculator(pricePerDay,numberOfDays,season,discount);

        System.out.printf("%.2f",priceCalculator.calculatePrice());
    }
}
