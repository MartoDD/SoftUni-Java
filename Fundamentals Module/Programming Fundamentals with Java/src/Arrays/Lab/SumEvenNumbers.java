package Arrays.Lab;

import java.util.Scanner;

public class SumEvenNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] elements = input.split(" ");
        int sum = 0;
        for (String element : elements) {
            int number = Integer.parseInt(element);
            if (number % 2 == 0) {
                sum += number;
            }
        }
        System.out.println(sum);

    }
}
