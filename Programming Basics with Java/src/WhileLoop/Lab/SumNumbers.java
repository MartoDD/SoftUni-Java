package WhileLoop.Lab;

import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int targetSum = scanner.nextInt();
        int sum = 0;

        while (sum < targetSum) {

            int input = scanner.nextInt();
            sum += input;
        }
        System.out.println(sum);
    }
}
