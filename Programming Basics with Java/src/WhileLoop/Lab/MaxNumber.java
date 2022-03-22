package WhileLoop.Lab;

import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int temp = Integer.MIN_VALUE;
        while (!input.equals("Stop")) {

            int number = Integer.parseInt(input);

            if (temp < number) {
                temp = number;
            }
            input = scanner.nextLine();
        }
        System.out.println(temp);
    }
}
