package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class _2_KnightsOfHonor {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Consumer<String> print = s-> System.out.println("Sir " + s);

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(print);
    }
}
