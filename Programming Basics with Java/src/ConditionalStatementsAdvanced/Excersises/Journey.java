package ConditionalStatementsAdvanced.Excersises;

import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = scanner.nextDouble();
        String season = scanner.next();
        String place;
        double expenses;
        String cOrH;

        if (budget <= 100) {
            place = "Bulgaria";
            if (season.equals("summer")) {
                expenses = budget * 0.30;
            } else {
                expenses = budget * 0.70;
            }
        } else if (budget <= 1000) {
            place = "Balkans";
            if (season.equals("summer")) {
                expenses = budget * 0.40;
            } else {
                expenses = budget * 0.80;
            }
        } else {
            place = "Europe";
            expenses = budget * 0.90;
        }
        if (season.equals("summer") && !place.equals("Europe")) {
            cOrH = "Camp";
        } else {
            cOrH = "Hotel";
        }
        System.out.printf("Somewhere in %s%n", place);
        System.out.printf("%s - %.2f", cOrH, expenses);
    }
}
