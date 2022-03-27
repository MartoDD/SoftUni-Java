package Exam;

import java.util.Scanner;

public class ExcursionCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        double price = 0;

        switch (season) {
            case "spring":
                if (people <= 5) {
                    price = 50.00 * people;
                } else {
                    price = 48.00 * people;
                }
                break;
            case "summer":
                if (people <= 5) {
                    price = 48.50 * people;
                } else {
                    price = 45.00 * people;
                }
                break;
            case "autumn":
                if (people <= 5) {
                    price = 60.00 * people;
                } else {
                    price = 49.50 * people;
                }
                break;
            case "winter":
                if (people <= 5) {
                    price = 86.00 * people;
                } else {
                    price = 85.00 * people;
                }
                break;
        }

        if (season.equals("summer")) {
            price *= 0.85;
        } else if (season.equals("winter")) {
            price *= 1.08;
        }

        System.out.printf("%.2f leva.", price);
    }
}
