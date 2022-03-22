package Arrays.MoreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] lisNumbers = new int[numbers.length];
        int[] indexNumbers = new int[numbers.length];
        int max = 0;
        int indexMax = -1;

        for (int i = 0; i < numbers.length; i++) {
            lisNumbers[i] = 1;
            indexNumbers[i] = -1;
        }

        for (int i = 1; i < numbers.length; i++) {
            for (int j = 0; j < i; j++) {

                if (numbers[j] < numbers[i]) {
                    int candidate = lisNumbers[j] + 1;
                    if (candidate > lisNumbers[i]) {
                        lisNumbers[i] = candidate;
                        indexNumbers[i] = j;
                    }
                }

            }
            for (int j = 0; j < lisNumbers.length; j++) {
                if (lisNumbers[j] > max) {
                    max = lisNumbers[j];
                    indexMax = j;
                }
            }
        }
        int[] output = new int[max];
        int index = 0;
        while (indexMax != -1) {
            output[index] = numbers[indexMax];
            indexMax = indexNumbers[indexMax];
            index++;
        }
        for (int i = output.length - 1; i >= 0; i--) {
            System.out.print(output[i] + " ");
        }
        if (numbers.length == 1) {
            System.out.println(numbers[0]);
        }

    }
}
