package ConditionalStatementsAdvanced.MoreExcersises;

import java.util.Scanner;

public class MatchTickets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = scanner.nextDouble();
        String category = scanner.next();
        double people = scanner.nextDouble();
        double needed = 0;


        if (people >= 5 && people <= 9) {
            budget *= 0.40;
        } else if (people >= 10 && people <= 24) {
            budget *= 0.50;
        } else if (people >= 25 && people <= 49) {
            budget *= 0.60;
        } else if (people >= 50) {
            budget *= 0.75;
        }else {
            budget*=0.25;
        }
        switch (category) {
            case "VIP":
                needed = 499.99*people;
                break;
            case "Normal":
                needed = 249.99*people;
                break;
        }
        if (needed > budget) {
            System.out.printf("Not enough money! You need %.2f leva.", needed - budget);
        } else {
            System.out.printf("Yes! You have %.2f leva left.", budget - needed);
        }
    }
}
