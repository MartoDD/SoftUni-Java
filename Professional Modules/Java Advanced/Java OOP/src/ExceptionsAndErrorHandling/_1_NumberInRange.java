package ExceptionsAndErrorHandling;

import java.util.Arrays;
import java.util.Scanner;

public class _1_NumberInRange {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] ranges = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int beginning = ranges[0];
        int end = ranges[1];

        System.out.printf("Range: [%d...%d]%n", beginning, end);

        boolean isInRange = false;

        while (!isInRange) {
            int number;
            String input = null;
            try {
                input = scanner.nextLine();
                number = Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid number: " + input);
                continue;
            }
            if (number >= beginning && number <= end) {
                System.out.println("Valid number: " + number);
                isInRange = true;
            } else {
                System.out.println("Invalid number: " + number);
            }
        }
    }
}
