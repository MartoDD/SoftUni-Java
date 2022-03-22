package Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int m = numbers[0];
        int c = numbers[0];

        int countM = 1;
        int countC = 1;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == c) {
                countC++;
                if (countC > countM) {
                    countM = countC;
                    m = c;
                }
            } else {
                c = numbers[i];
                countC = 1;
            }
        }

        for (int i = 0; i < countM; i++) {
            System.out.print(m + " ");
        }
    }
}
