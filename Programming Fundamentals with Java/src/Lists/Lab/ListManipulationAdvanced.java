package Lists.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            String[] commands = input.split(" ");

            switch (commands[0]) {
                case "Contains":
                    int value = Integer.parseInt(commands[1]);
                    boolean contains = checkIfContainsNumber(numbers, value);
                    if (contains) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if (commands[1].equals("even")) {
                        for (Integer number : numbers) {
                            if (number % 2 == 0) {
                                System.out.print(number + " ");
                            }
                        }
                        System.out.println();
                    } else if (commands[1].equals("odd")) {
                        for (Integer number : numbers) {
                            if (number % 2 != 0) {
                                System.out.print(number + " ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case "Get":
                    int sum = 0;
                    for (Integer number : numbers) {
                        sum += number;
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    int numb = Integer.parseInt(commands[2]);
                    String condition = commands[1];
                    printResult(numbers, numb, condition);
                    break;

            }


            input = scanner.nextLine();
        }

    }

    private static void printResult(List<Integer> numbers, int numb, String condition) {

        switch (condition) {
            case ">":
                for (Integer number : numbers) {
                    if (number > numb) {
                        System.out.print(number + " ");
                    }
                }
                System.out.println();
                break;
            case "<":
                for (Integer number : numbers) {
                    if (number < numb) {
                        System.out.print(number + " ");
                    }
                }
                System.out.println();
                break;
            case ">=":
                for (Integer number : numbers) {
                    if (number >= numb) {
                        System.out.print(number + " ");
                    }
                }
                System.out.println();
                break;
            case "<=":
                for (Integer number : numbers) {
                    if (number <= numb) {
                        System.out.print(number + " ");
                    }
                }
                System.out.println();
                break;
        }
    }

    private static boolean checkIfContainsNumber(List<Integer> numbers, int value) {

        for (Integer number : numbers) {
            if (number.equals(value)) {
                return true;
            }
        }
        return false;
    }
}



