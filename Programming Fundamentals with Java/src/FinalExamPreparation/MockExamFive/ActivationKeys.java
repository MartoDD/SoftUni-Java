package FinalExamPreparation.MockExamFive;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder rawKey = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Generate")) {

            String[] instructions = input.split(">>>");

            String command = instructions[0];

            switch (command) {
                case "Contains":
                    String substring = instructions[1];
                    if (rawKey.toString().contains(substring)) {
                        System.out.println(rawKey + " contains " + substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String upLow = instructions[1];
                    int startIndex = Integer.parseInt(instructions[2]);
                    int endIndex = Integer.parseInt(instructions[3]);
                    String substr = rawKey.substring(startIndex, endIndex);
                    String upperOrLower = "";
                    if (upLow.equals("Upper")) {
                        upperOrLower = substr.toUpperCase();
                    } else if (upLow.equals("Lower")) {
                        upperOrLower = substr.toLowerCase();
                    }
                    rawKey.replace(startIndex, endIndex, upperOrLower);
                    System.out.println(rawKey);
                    break;
                case "Slice":
                    int start = Integer.parseInt(instructions[1]);
                    int end = Integer.parseInt(instructions[2]);

                    rawKey.delete(start, end);
                    System.out.println(rawKey);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + rawKey);
    }
}
