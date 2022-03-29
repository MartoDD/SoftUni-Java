package FinalExamPreparation.MockExamFour;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("Done")) {
            String[] data = command.split("\\s+");
            switch (data[0]) {
                case "TakeOdd":
                    StringBuilder temp = new StringBuilder();
                    for (int i = 0; i < input.length(); i++) {
                        if (i % 2 != 0) {
                            temp.append(input.charAt(i));
                        }
                    }
                    input = temp;
                    System.out.println(input);
                    break;
                case "Cut":
                    int index = Integer.parseInt(data[1]);
                    int length = Integer.parseInt(data[2]);
                    String substring = input.substring(index, index + length);
                    int indexStart = input.indexOf(substring);
                    input.delete(indexStart, indexStart + length);
                    System.out.println(input);
                    break;
                case "Substitute":
                    String substringToReplace = data[1];
                    String replacement = data[2];
                    if (input.toString().contains(substringToReplace)) {
                        while (input.toString().contains(substringToReplace)) {
                            int startingIndex = input.indexOf(substringToReplace);
                            input.replace(startingIndex, startingIndex + substringToReplace.length(), replacement);
                        }
                        System.out.println(input);
                    } else {
                        System.out.println("Nothing to replace!");
                    }

                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Your password is: " + input);
    }
}
