package BasicSyntaxConditionalStatementsAndLoops.MoreExercises;

import java.util.Scanner;

public class Messages {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int counter = 0;


        StringBuilder message = new StringBuilder();


        while (counter != n) {

            String input = scanner.nextLine();

            counter++;
            int digit;
            int length = input.length();

            int number = Integer.parseInt(input);

            if (number <= 9) {
                digit = number;
            } else {
                digit = number % 10;
            }
            switch (digit) {
                case 0:
                    message.append(" ");
                    break;
                case 1:
                    break;
                case 2:
                    switch (length) {
                        case 1:
                            message.append("a");
                            break;
                        case 2:
                            message.append("b");
                            break;
                        case 3:
                            message.append("c");
                            break;
                    }
                    break;
                case 3:
                    switch (length) {
                        case 1:
                            message.append("d");
                            break;
                        case 2:
                            message.append("e");
                            break;
                        case 3:
                            message.append("f");
                            break;
                    }
                    break;
                case 4:
                    switch (length) {
                        case 1:
                            message.append("g");
                            break;
                        case 2:
                            message.append("h");
                            break;
                        case 3:
                            message.append("i");
                            break;
                    }
                    break;
                case 5:
                    switch (length) {
                        case 1:
                            message.append("j");
                            break;
                        case 2:
                            message.append("k");
                            break;
                        case 3:
                            message.append("l");
                            break;
                    }
                    break;
                case 6:
                    switch (length) {
                        case 1:
                            message.append("m");
                            break;
                        case 2:
                            message.append("n");
                            break;
                        case 3:
                            message.append("o");
                            break;
                    }
                    break;
                case 7:
                    switch (length) {
                        case 1:
                            message.append("p");
                            break;
                        case 2:
                            message.append("q");
                            break;
                        case 3:
                            message.append("r");
                            break;
                        case 4:
                            message.append("s");
                            break;
                    }
                    break;
                case 8:
                    switch (length) {
                        case 1:
                            message.append("t");
                            break;
                        case 2:
                            message.append("u");
                            break;
                        case 3:
                            message.append("v");
                            break;

                    }
                    break;
                case 9:
                    switch (length) {
                        case 1:
                            message.append("w");
                            break;
                        case 2:
                            message.append("x");
                            break;
                        case 3:
                            message.append("y");
                            break;
                        case 4:
                            message.append("z");
                            break;
                    }
                    break;
            }


        }
        System.out.println(message);
    }
}
