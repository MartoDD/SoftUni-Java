package ConditionalStatementsAdvanced.Excersises;

import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int budget = scanner.nextInt();
        String season = scanner.next();
        int fisherman = scanner.nextInt();
        double price = 0;

        switch (season) {
            case "Spring":
                if (fisherman <= 6) {
                    price = 3000 * 0.90;
                } else if (fisherman <= 11) {
                    price = 3000 * 0.85;
                } else {
                    price = 3000 * 0.75;
                }
                break;
            case "Autumn":
            case "Summer":
                if (fisherman <= 6) {
                    price = 4200 * 0.90;
                } else if (fisherman <= 11) {
                    price = 4200 * 0.85;
                } else {
                    price = 4200 * 0.75;
                }
                break;
            case "Winter":
                if (fisherman <= 6) {
                    price = 2600 * 0.90;
                } else if (fisherman <= 11) {
                    price = 2600 * 0.85;
                } else {
                    price = 2600 * 0.75;
                }
                break;
        }
        if ((fisherman % 2 == 0) && !season.equals("Autumn")) {
            price *= 0.95;
        }

        if (budget >= price) {
            System.out.printf("Yes! You have %.2f leva left.", budget - price);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", price - budget);
        }
    }
}
