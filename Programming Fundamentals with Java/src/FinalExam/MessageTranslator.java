package FinalExam;

import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTranslator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "!(?<command>[A-Z][a-z]{2,})!:\\[(?<string>[A-Za-z]{8,})\\]";

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String word = matcher.group("string");
                String command = matcher.group("command");
                System.out.print(command + ": ");
                for (int j = 0; j < word.length(); j++) {
                    System.out.print((int) word.charAt(j) + " ");
                }
                System.out.println();
            } else {
                System.out.println("The message is invalid");
            }

        }
    }
}
