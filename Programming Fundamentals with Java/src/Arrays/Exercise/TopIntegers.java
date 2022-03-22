package Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder fin = new StringBuilder();
        boolean isBigger = true;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] <= arr[j]) {
                    isBigger = false;
                    break;
                }
            }
            if (isBigger) {
                fin.append(arr[i]).append(" ");
            } else {
                isBigger = true;
            }

            if (i == arr.length - 2) {
                fin.append(arr[i + 1]);
            }
        }
        System.out.println(fin);
    }
}
