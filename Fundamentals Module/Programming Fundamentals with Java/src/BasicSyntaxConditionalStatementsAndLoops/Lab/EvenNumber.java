package BasicSyntaxConditionalStatementsAndLoops.Lab;

import java.util.Scanner;

public class EvenNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        while (input % 2 != 0) {

            System.out.println("Please write an even number.");

            input = scanner.nextInt();
        }
        System.out.printf("The number is: %d", Math.abs(input));
    }
}
