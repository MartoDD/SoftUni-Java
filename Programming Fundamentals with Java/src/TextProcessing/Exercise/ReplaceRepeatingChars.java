package TextProcessing.Exercise;

import java.util.Scanner;

public class ReplaceRepeatingChars {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder shorter = new StringBuilder();
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) != input.charAt(i + 1)) {
                shorter.append(input.charAt(i));
            }
            if (i == input.length() - 2) {
                shorter.append(input.charAt(i + 1));
            }

        }
        System.out.println(shorter);
    }
}
