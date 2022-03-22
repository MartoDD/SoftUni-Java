package TextProcessing.Exercise;

import java.util.Scanner;

public class ValidUsernames {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        boolean isValid = true;
        for (String s : input) {
            if (s.length() >= 3 && s.length() <= 16) {
                for (int i = 0; i < s.length(); i++) {
                    if (!Character.isAlphabetic(s.charAt(i)) && !Character.isDigit(s.charAt(i)) && s.charAt(i) != '-' && s.charAt(i) != '_') {
                        isValid = false;
                    }
                }
                if (isValid) {
                    System.out.println(s);
                }
                isValid = true;
            }
        }

    }
}
