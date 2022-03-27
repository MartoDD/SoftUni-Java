package TextProcessing.Lab;

import java.util.Scanner;

public class DigitsLettersAndOther {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        for (int j = 0; j < input.length(); j++) {
            if (Character.isDigit(input.charAt(j))) {
                System.out.print(input.charAt(j));
            }
        }
        System.out.println();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isAlphabetic(input.charAt(i))) {
                System.out.print(input.charAt(i));
            }
        }
        System.out.println();
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i)) && !Character.isAlphabetic(input.charAt(i))) {
                System.out.print(input.charAt(i));
            }
        }

    }
}
