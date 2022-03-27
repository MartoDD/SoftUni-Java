package TextProcessing.Lab;

import java.util.Scanner;

public class TextFilter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String input = scanner.nextLine();

        for (String s : bannedWords) {
            input = input.replaceAll(s, repeat(s.length()));
        }

        System.out.println(input);

    }

    private static String repeat(int length) {
        return "*".repeat(Math.max(0, length));
    }
}
