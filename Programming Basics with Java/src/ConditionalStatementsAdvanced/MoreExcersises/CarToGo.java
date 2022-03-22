package ConditionalStatementsAdvanced.MoreExcersises;

import java.util.Scanner;

public class CarToGo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = scanner.nextDouble();
        String season = scanner.next();
        String type;
        double cabrio = 0;
        double jeep = 0;
        if (budget <= 100) {
            type = "Economy class";

        } else if (budget > 100 && budget <= 500) {
            type = "Compact class";
        } else {
            type = "Luxury class";
        }
        switch (season) {
            case "Summer":
                if (type.equals("Economy class")) {
                    cabrio = budget * 0.35;
                } else if (type.equals("Compact class")) {
                    cabrio = budget * 0.45;
                }
                break;
            case "Winter":
                if (type.equals("Economy class")) {
                    jeep = budget * 0.65;
                } else if (type.equals("Compact class")) {
                    jeep = budget * 0.80;
                }
        }
        System.out.println(type);
        if (season.equals("Summer") && !type.equals("Luxury class")) {
            System.out.printf("Cabrio - %.2f", cabrio);
        } else if (season.equals("Winter") && !type.equals("Luxury class")) {
            System.out.printf("Jeep - %.2f", jeep);
        } else {
            System.out.printf("Jeep - %.2f", jeep = budget * 0.90);
        }
    }
}
