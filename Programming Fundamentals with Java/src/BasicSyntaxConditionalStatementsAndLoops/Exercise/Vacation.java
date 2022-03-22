package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String day = scanner.nextLine();
        double price = 0;
        double totalPrice;

        switch (type) {
            case "Students":
                switch (day) {
                    case "Friday":
                        price = 8.45;
                        break;
                    case "Saturday":
                        price = 9.80;
                        break;
                    case "Sunday":
                        price = 10.46;
                        break;
                }
                break;
            case "Business":
                switch (day) {
                    case "Friday":
                        price = 10.90;
                        break;
                    case "Saturday":
                        price = 15.60;
                        break;
                    case "Sunday":
                        price = 16.00;
                        break;
                }
                break;
            case "Regular":
                switch (day) {
                    case "Friday":
                        price = 15.00;
                        break;
                    case "Saturday":
                        price = 20.00;
                        break;
                    case "Sunday":
                        price = 22.50;
                        break;
                }
                break;
        }

        if (type.equals("Students") && people >= 30) {
            price *= 0.85;
        }
        if (type.equals("Business") && people >= 100) {
            people -= 10;
        }
        if (type.equals("Regular") && people >= 10 && people <= 20) {
            price *= 0.95;
        }
        totalPrice = price * people;
        System.out.printf("Total price: %.2f", totalPrice);
    }
}
