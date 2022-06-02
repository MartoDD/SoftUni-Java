package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _6_FindEvensOrOdds {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] parameters = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int start = parameters[0];
        int end = parameters[1];

        String condition = scanner.nextLine();


        System.out.println(IntStream.rangeClosed(start, end).boxed().filter(getPredicate(condition)).map(String::valueOf).collect(Collectors.joining(" ")));

    }

    private static Predicate<Integer> getPredicate(String condition) {
        switch (condition) {
            case "odd":
                return n -> n % 2 != 0;
            case "even":
                return n -> n % 2 == 0;
            default:
                throw new IllegalStateException();
        }
    }
}
