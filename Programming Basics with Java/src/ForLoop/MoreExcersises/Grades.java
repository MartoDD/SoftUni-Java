package ForLoop.MoreExcersises;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        double grade;
        double allGrades = 0;

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;

        for (int i = 0; i < n; i++) {

            grade = scanner.nextDouble();
            allGrades += grade;

            if (grade >= 5.00) {
                p1++;
            } else if (grade >= 4.00) {
                p2++;
            } else if (grade >= 3.00) {
                p3++;
            } else {
                p4++;
            }
        }

        System.out.printf("Top students: %.2f%%%nBetween 4.00 and 4.99: %.2f%%%nBetween 3.00 and 3.99: %.2f%%%nFail: %.2f%%%nAverage: %.2f", p1 * 1.0 / n * 100, p2 * 1.0 / n * 100, p3 * 1.0 / n * 100, p4 * 1.0 / n * 100, allGrades / n);
    }
}
