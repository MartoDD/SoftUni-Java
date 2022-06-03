package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class _6_PredicateForNames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());

        Predicate<String> isItLonger = n -> n.length() <= length;
        Arrays.stream(scanner.nextLine().split("\\s+")).filter(isItLonger).forEach(System.out::println);
    }
}
