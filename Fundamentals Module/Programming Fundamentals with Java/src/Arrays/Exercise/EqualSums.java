package Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] number = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sumBefore = 0;
        int sumAfter = 0;
        int index = 0;
        boolean isEqual = false;

        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < i; j++) {
                sumBefore += number[j];
            }
            for (int j = i + 1; j < number.length; j++) {
                sumAfter += number[j];
            }
            if (sumBefore == sumAfter) {
                index = i;
                isEqual = true;
            }
            sumAfter = 0;
            sumBefore = 0;
        }
        if (isEqual) {
            System.out.println(index);
        } else {
            System.out.println("no");
        }
    }
}
