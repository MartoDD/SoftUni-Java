package Methods.Exercises;

import java.util.Scanner;

public class PasswordValidator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        boolean ruleOne = chekLenght(input);
        boolean ruleTwo = checkContents(input);
        boolean ruleThree = checkDigits(input);

        if (ruleOne && ruleTwo && ruleThree) {
            System.out.println("Password is valid");
        }
    }

    private static boolean checkDigits(String input) {

        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 48 && input.charAt(i) <= 57) {
                count++;
                if (count >= 2) {
                    return true;
                }
            }

        }
        System.out.println("Password must have at least 2 digits");
        return false;
    }

    private static boolean checkContents(String input) {

        for (int i = 0; i < input.length(); i++) {

            if ((input.charAt(i) >= 48 && input.charAt(i) <= 57) || (input.charAt(i) >= 65 && input.charAt(i) <= 90) || (input.charAt(i) >= 97 && input.charAt(i) <= 122)) {

            } else {
                System.out.println("Password must consist only of letters and digits");
                return false;
            }

        }
        return true;
    }

    private static boolean chekLenght(String input) {

        if (input.length() >= 6 && input.length() <= 10) {
            return true;
        } else {
            System.out.println("Password must be between 6 and 10 characters");
            return false;
        }
    }
}
