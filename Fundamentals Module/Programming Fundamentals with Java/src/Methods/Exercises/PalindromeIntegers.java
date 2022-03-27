package Methods.Exercises;

import java.util.Scanner;

public class PalindromeIntegers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")){


            printIfPalindrom(input);

            input= scanner.nextLine();
        }
    }

    private static void printIfPalindrom(String input) {

        StringBuilder backwards = new StringBuilder();

        for (int i = input.length()-1; i >=0 ; i--) {
        backwards.append(input.charAt(i));
        }
        System.out.println(input.equals(backwards.toString()));
    }
}
