package ConditionalStatements.Excersises;

import java.util.Scanner;

public class BonusScore {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double points = scanner.nextInt();

        if (points <= 100) {
            if (points % 2 == 0) {
                double totalPoints = points + 6;
                System.out.println("6.0");
                System.out.printf("%n%.1f", totalPoints);
            } else if (points % 10 == 5) {
                double totalPoints = points + 7;
                System.out.println("7.0");
                System.out.printf("%n%.1f", totalPoints);
            } else {
                double totalPoints = points + 5;
                System.out.println("5.0");
                System.out.printf("%n%.1f", totalPoints);
            }
        } else if (points < 1000) {
            if (points % 2 == 0) {
                double bonusPoints = points * 0.20 + 1;
                double totalPoints = bonusPoints + points;
                System.out.printf("%.1f%n", bonusPoints);
                System.out.printf("%.1f", totalPoints);
            } else if (points % 10 == 5) {
                double bonusPoints = points * 0.20 + 2;
                double totalPoints = bonusPoints + points;
                System.out.printf("%.1f%n", bonusPoints);
                System.out.printf("%.1f", totalPoints);
            } else {
                double bonusPoints = points * 0.20;
                double totalPoints = bonusPoints + points;
                System.out.printf("%.1f%n", bonusPoints);
                System.out.printf("%.1f", totalPoints);
            }

        } else {
            if (points % 2 == 0) {
                double bonusPoints = points * 0.10 + 1;
                double totalPoints = bonusPoints + points;
                System.out.printf("%.1f%n", bonusPoints);
                System.out.printf("%.1f", totalPoints);
            } else if (points % 10 == 5) {
                double bonusPoints = points * 0.10 + 2;
                double totalPoints = bonusPoints + points;
                System.out.printf("%.1f%n", bonusPoints);
                System.out.printf("%.1f", totalPoints);
            } else {
                double bonusPoints = points * 0.10;
                double totalPoints = bonusPoints + points;
                System.out.printf("%.1f%n", bonusPoints);
                System.out.printf("%.1f", totalPoints);
            }
        }
    }
}
