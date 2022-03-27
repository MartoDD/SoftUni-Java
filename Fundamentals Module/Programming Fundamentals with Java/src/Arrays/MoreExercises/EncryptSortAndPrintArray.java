package Arrays.MoreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {

            String input = scanner.nextLine();

            for (int j = 0; j < input.length(); j++) {

                if (input.charAt(j) == 65 || input.charAt(j) == 97 || input.charAt(j) == 69 || input.charAt(j) == 101 || input.charAt(j) == 73 || input.charAt(j) == 105 || input.charAt(j) == 79 || input.charAt(j) == 111 || input.charAt(j) == 85 || input.charAt(j) == 117) {
                    sum += input.charAt(j) * input.length();
                } else {
                    sum += input.charAt(j) / input.length();
                }
            }
            numbers[i] = sum;
            sum = 0;
        }
        Arrays.sort(numbers);
        for (int nu : numbers) {
            System.out.println(nu);
        }
    }
}
