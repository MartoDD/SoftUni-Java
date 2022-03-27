package FinalExamPreparation.MockExamThree;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Reveal")) {

            String[] instructions = input.split(":\\|:");

            String order = instructions[0];

            switch (order) {
                case "InsertSpace":
                    int index = Integer.parseInt(instructions[1]);
                    message.insert(index, " ");
                    System.out.println(message);
                    break;
                case "Reverse":
                    StringBuilder substring = new StringBuilder(instructions[1]);
                    if (message.toString().contains(substring)) {
                        int startIndex = message.indexOf(substring.toString());
                        message.delete(startIndex, startIndex + substring.length());
                        substring.reverse();
                        message.append(substring);
                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String toBeReplace = instructions[1];
                    String replacement = instructions[2];
                    while (message.toString().contains(toBeReplace)) {
                        int startIndex = message.indexOf(toBeReplace);
                        message.replace(startIndex, startIndex + toBeReplace.length(), replacement);
                    }
                    System.out.println(message);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + message);
    }
}
