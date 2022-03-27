package Exam;

import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int students = scanner.nextInt();
        int top = 0;
        int second = 0;
        int third = 0;
        int fail = 0;
        double sum = 0;

        for (int i = 1; i <= students; i++) {
            double grade = scanner.nextDouble();
            sum += grade;

            if (grade >= 5.00) {
                top++;
            } else if (grade >= 4.00 && grade <= 4.99) {
                second++;
            } else if (grade >= 3.00 && grade <= 3.99) {
                third++;
            } else {
                fail++;
            }
        }
        double avg = sum / students;

        System.out.printf("Top students: %.2f%%%n", top * 1.0 / students * 100);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", second * 1.0 / students * 100);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", third * 1.0 / students * 100);
        System.out.printf("Fail: %.2f%%%n", fail * 1.0 / students * 100);
        System.out.printf("Average: %.2f", avg);
    }
}
