package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class _4_AppliedArithmetics {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        UnaryOperator<List<Integer>> add = arr -> arr.stream().map(n -> n + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiply = arr -> arr.stream().map(n -> n * 2).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtract = arr -> arr.stream().map(n -> n - 1).collect(Collectors.toList());
        Consumer<List<Integer>> print = arr -> arr.forEach(integer -> System.out.print(integer + " "));

        while (!input.equals("end")) {

            switch (input) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
