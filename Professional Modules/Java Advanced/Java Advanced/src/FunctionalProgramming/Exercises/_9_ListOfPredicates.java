package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _9_ListOfPredicates {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int end = Integer.parseInt(scanner.nextLine());

        List<Integer> divisible = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Predicate<Integer> isDivisible = n -> {
            for (Integer integer : divisible) {
                if (n % integer != 0) {
                    return false;
                }
            }
            return true;
        };

        IntStream.rangeClosed(1, end).boxed().filter(isDivisible).forEach(n -> System.out.print(n + " "));
    }
}
