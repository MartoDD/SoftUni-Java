package DataTypesAndVariables.MoreExercise;

import java.util.Scanner;

public class DataTypeFinder {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {


            if ((input.contains(",") || (input.contains(".")))) {

                System.out.printf("%s is floating point type%n", input);

            } else if (input.contains("0") || input.contains("1") || input.contains("2") || input.contains("3") || input.contains("4") || input.contains("5") || input.contains("6") || input.contains("7") || input.contains("8") || input.contains("9")) {

                System.out.printf("%s is integer type%n", input);

            } else if (input.length() == 1) {

                System.out.printf("%s is character type%n", input);

            } else if (input.equals("true") || input.equals("false")) {

                System.out.printf("%s is boolean type%n", input);

            } else {

                System.out.printf("%s is string type%n", input);
            }


            input = scanner.nextLine();
        }
    }
}
