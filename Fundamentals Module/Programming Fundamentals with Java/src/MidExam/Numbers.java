package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Finish")) {
            String[] commands = input.split("\\s+");
            int value;
            switch (commands[0]) {
                case "Add":
                    value = Integer.parseInt(commands[1]);
                    numbers.add(value);
                    break;
                case "Remove":
                    value = Integer.parseInt(commands[1]);
                    removeGivenValue(numbers, value);
                    break;
                case "Replace":
                    value = Integer.parseInt(commands[1]);
                    int valueTwo = Integer.parseInt(commands[2]);
                    replaceGivenValueWithNew(numbers, value, valueTwo);
                    break;
                case "Collapse":
                    value = Integer.parseInt(commands[1]);
                    removeAllNumbersUnderCertainValue(numbers, value);
                    break;
            }


            input = scanner.nextLine();
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }

    }

    private static void removeAllNumbersUnderCertainValue(List<Integer> numbers, int value) {
        int i = 0;
        while (i < numbers.size()) {
            if (numbers.get(i) < value) {
                numbers.remove(i);
            } else {
                i++;
            }
        }
    }

    private static void replaceGivenValueWithNew(List<Integer> numbers, int value, int valueTwo) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == value) {
                numbers.set(i, valueTwo);
                break;
            }
        }
    }

    private static void removeGivenValue(List<Integer> numbers, int value) {
        for (Integer number : numbers) {
            if (number == value) {
                numbers.remove(number);
                break;
            }
        }
    }
}
