package Arrays.MoreExercises;

import java.util.Scanner;

public class RecursiveFibonacci {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] fib = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                fib[0] = 1;
            } else if (i == 1) {
                fib[1] = 1;
            } else {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        }
        if (n != 0) {
            System.out.println(fib[n - 1]);
        } else {
            System.out.println(0);
        }

    }
}
