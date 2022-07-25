package ExceptionsAndErrorHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _3_EnterNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int start = 1;
        int end = 100;

        List<Integer> numbers = new ArrayList<>();
        int counter = 1;
        while (counter <= 10) {
            int number = 0;
            try {
                number = readNumber(start, end, scanner);
                counter++;
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                continue;
            }
            start = number;
            numbers.add(number);


        }
        System.out.println(numbers.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }

    private static int readNumber(int start, int end, Scanner scanner) {
        int number = 0;
        try {
            number = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalStateException("Invalid Number!");
        }

        if (number <= start || number >= end) {
            throw new IllegalStateException(String.format("Your number is not in range %d - %d!", start, end));
        } else {
            return number;
        }
    }
}
