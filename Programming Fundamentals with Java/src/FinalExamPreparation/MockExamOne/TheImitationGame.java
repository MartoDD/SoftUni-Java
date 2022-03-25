package FinalExamPreparation.MockExamOne;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Decode")) {
            String[] data = input.split("\\|");

            switch (data[0]) {
                case "Move":
                    int numbersOfLetters = Integer.parseInt(data[1]);
                    for (int i = 0; i < numbersOfLetters; i++) {
                        message.append(message.charAt(0));
                        message.deleteCharAt(0);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(data[1]);
                    String value = data[2];
                    message.insert(index, value);
                    break;
                case "ChangeAll":
                    String substring = data[1];
                    String replacement = data[2];
                    while (message.toString().contains(substring)) {
                        int indexx = message.indexOf(substring);
                        message.replace(indexx, indexx + substring.length(), replacement);

                    }
                    break;
            }


            input = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + message);


    }
}
