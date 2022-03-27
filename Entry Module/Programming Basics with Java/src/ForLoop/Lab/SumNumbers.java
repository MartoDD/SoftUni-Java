package ForLoop.Lab;

import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int sum = 0;

        for (int i = 1; i <= n; i++) {
           int input = scanner.nextInt();
            sum += input;

        }
        System.out.println(sum);
    }
}
