package Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        while (arr.length > 1) {
            int[] condensed = new int[arr.length - 1];
            for (int j = 0; j < arr.length - 1; j++) {
                condensed[j] = arr[j] + arr[j + 1];

            }
            arr = condensed;
        }
        for (int number : arr) {
            System.out.println(number);
        }

    }
}
