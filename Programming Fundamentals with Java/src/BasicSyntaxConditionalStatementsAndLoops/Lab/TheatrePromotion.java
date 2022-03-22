package BasicSyntaxConditionalStatementsAndLoops.Lab;

import java.util.Scanner;

public class TheatrePromotion {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String day = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        int price = 0;

        switch (day) {
            case "Weekday":
                if (age >= 0 && age <= 18) {
                    price = 12;
                } else if (age <= 64 && age > 18) {
                    price = 18;
                } else if (age <= 122 && age > 64) {
                    price = 12;
                }
                break;
            case "Weekend":
                if (age >= 0 && age <= 18) {
                    price = 15;
                } else if (age <= 64 && age > 18) {
                    price = 20;
                } else if (age <= 122 && age > 64) {
                    price = 15;
                }
                break;
            case "Holiday":
                if (age >= 0 && age <= 18) {
                    price = 5;
                } else if (age <= 64 && age > 18) {
                    price = 12;
                } else if (age <= 122 && age > 64) {
                    price = 10;
                }
                break;
        }
        if (price != 0) {
            System.out.printf("%d$", price);
        } else {
            System.out.println("Error!");
        }
    }
}
