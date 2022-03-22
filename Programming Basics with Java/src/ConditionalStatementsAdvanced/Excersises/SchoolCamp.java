package ConditionalStatementsAdvanced.Excersises;

import java.util.Scanner;

public class SchoolCamp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        String gender = scanner.nextLine();
        double numberStudents = scanner.nextInt();
        double nights = scanner.nextInt();
        String sport = "";
        double price = 0;

        switch (season) {
            case "Winter":
                if (gender.equals("mixed")) {
                    sport = "Ski";
                    price = nights * numberStudents * 10;
                } else if (gender.equals("boys")) {
                    sport = "Judo";
                    price = nights * numberStudents * 9.60;
                } else {
                    sport = "Gymnastics";
                    price = nights * numberStudents * 9.60;
                }
                break;
            case "Spring":
                if (gender.equals("mixed")) {
                    sport = "Cycling";
                    price = nights * numberStudents * 9.50;
                } else if (gender.equals("boys")) {
                    sport = "Tennis";
                    price = nights * numberStudents * 7.20;
                } else {
                    sport = "Athletics";
                    price = nights * numberStudents * 7.20;
                }
                break;
            case "Summer":
                if (gender.equals("mixed")) {
                    sport = "Swimming";
                    price = nights * numberStudents * 20;
                } else if (gender.equals("boys")) {
                    sport = "Football";
                    price = nights * numberStudents * 15;
                } else {
                    sport = "Volleyball";
                    price = nights * numberStudents * 15;
                }
                break;
        }
        if (numberStudents >= 50) {
            price *= 0.50;
        } else if (numberStudents >= 20) {
            price *= 0.85;
        } else if (numberStudents >= 10) {
            price *= 0.95;
        }
        System.out.printf("%s %.2f lv.", sport, price);
    }
}
