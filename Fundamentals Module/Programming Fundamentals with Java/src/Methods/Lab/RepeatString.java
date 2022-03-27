package Methods.Lab;

import java.util.Scanner;

public class RepeatString {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        printStringTimes(str, n);
    }

    private static void printStringTimes(String input, int times) {

        for (int i = 0; i < times; i++) {
            System.out.print(input);
        }
    }
}
