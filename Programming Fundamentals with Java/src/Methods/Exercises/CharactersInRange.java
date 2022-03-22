package Methods.Exercises;

import java.util.Scanner;

public class CharactersInRange {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char a = scanner.nextLine().charAt(0);
        char b = scanner.next().charAt(0);

        printAllCharBetween(a, b);
    }

    private static void printAllCharBetween(char a, char b) {

        if (a <= b) {
            for (int i = a + 1; i < b; i++) {

                System.out.print((char) i + " ");

            }
        } else {
            for (int i = b + 1; i < a; i++) {

                System.out.print((char) i + " ");

            }
        }

    }
}
