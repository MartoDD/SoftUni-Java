package ForLoop.MoreExcersises;

import java.util.Scanner;

public class GameOfIntervals {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int score;
        double totalScore = 0;

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;
        int p5 = 0;
        int p6 = 0;

        for (int i = 0; i < n; i++) {

            score = scanner.nextInt();

            if (score <= 9 && score >= 0) {
                p1++;
                totalScore += score * 0.20;
            } else if (score <= 19 && score >= 0) {
                p2++;
                totalScore += score * 0.30;
            } else if (score <= 29 && score >= 0) {
                p3++;
                totalScore += score * 0.40;
            } else if (score <= 39 && score >= 0) {
                p4++;
                totalScore += 50;
            } else if (score <= 50 && score >= 0) {
                p5++;
                totalScore += 100;
            } else {
                p6++;
                totalScore /= 2;
            }

        }

        System.out.printf("%.2f%n", totalScore);
        System.out.printf("From 0 to 9: %.2f%%%n", p1 * 1.0 / n * 100);
        System.out.printf("From 10 to 19: %.2f%%%n", p2 * 1.0 / n * 100);
        System.out.printf("From 20 to 29: %.2f%%%n", p3 * 1.0 / n * 100);
        System.out.printf("From 30 to 39: %.2f%%%n", p4 * 1.0 / n * 100);
        System.out.printf("From 40 to 50: %.2f%%%n", p5 * 1.0 / n * 100);
        System.out.printf("Invalid numbers: %.2f%%", p6 * 1.0 / n * 100);
    }
}
