package Methods.Exercises;

import java.util.Scanner;

public class AddAndSubtract {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();


        System.out.println(finalResult(a, b, c));
    }

    private static int finalResult(int a, int b, int c) {

        return sum(a, b) - c;
    }

    private static int sum(int a, int b) {

        return a + b;
    }
}
