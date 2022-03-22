package ForLoop.Lab;

import java.util.Scanner;

public class NumberSequence {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int temp;
        for (int i = 1; i <=n; i++) {
            temp = scanner.nextInt();

            if (max < temp) {

                max = temp;
            }
            if (min > temp) {
                min = temp;
            }


        }
        System.out.println("Max number: " + max);
        System.out.println("Min number: " + min);
    }
}
