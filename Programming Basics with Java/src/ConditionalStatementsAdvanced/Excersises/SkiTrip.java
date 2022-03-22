package ConditionalStatementsAdvanced.Excersises;

import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine()) - 1;
        String roomType = scanner.nextLine();
        String rate = scanner.nextLine();
        double price = 0;

        switch (roomType) {

            case "room for one person":
                price = days * 18.00;
                break;
            case "apartment":
                price = days * 25.00;
                if (days < 10) {
                    price *= 0.70;
                } else if (days <= 15) {
                    price *= 0.65;
                } else {
                    price *= 0.50;
                }
                break;
            case "president apartment":
                price = days * 35.00;
                if (days < 10) {
                    price *= 0.90;
                } else if (days <= 15) {
                    price *= 0.85;
                } else {
                    price *= 0.80;
                }
                break;
        }
        if (rate.equals("positive")) {
            price *= 1.25;
        } else {
            price *= 0.90;
        }
        System.out.printf("%.2f", price);
    }
}
