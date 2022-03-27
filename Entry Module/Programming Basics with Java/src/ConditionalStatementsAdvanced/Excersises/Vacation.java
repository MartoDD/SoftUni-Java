package ConditionalStatementsAdvanced.Excersises;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = scanner.nextDouble();
        String season = scanner.next();
        double price = 0;
        String area = "";
        String place;

        if (budget <= 1000) {
            place = "Camp";
        } else if (budget > 1000 && budget <= 3000) {
            place = "Hut";
        } else {
            place = "Hotel";
        }

        switch (season) {
            case "Summer":
                area = "Alaska";
                if (place.equals("Camp")) {
                    price = budget * 0.65;
                } else if (place.equals("Hut")) {
                    price = budget * 0.80;
                } else {
                    price = budget * 0.90;
                }
                break;
            case "Winter":
                area = "Morocco";
                if (place.equals("Camp")) {
                    price = budget * 0.45;
                } else if (place.equals("Hut")) {
                    price = budget * 0.60;
                } else {
                    price = budget * 0.90;
                }

        }
        System.out.printf("%s - %s - %.2f", area, place, price);
    }
}

