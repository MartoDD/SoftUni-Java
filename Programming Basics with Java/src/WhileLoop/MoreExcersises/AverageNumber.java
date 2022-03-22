package WhileLoop.MoreExcersises;

import java.util.Scanner;

public class AverageNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int sum = 0;

        for (int i = 1; i <= n; i++) {

            int input = scanner.nextInt();
            sum += input;
        }
        double avg = sum * 1.0 / n;
        System.out.printf("%.2f", avg);
    }
}
