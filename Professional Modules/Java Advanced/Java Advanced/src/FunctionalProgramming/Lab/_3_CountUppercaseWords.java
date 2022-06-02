package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _3_CountUppercaseWords {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Predicate<String> uppercase = w -> Character.isUpperCase(w.charAt(0));

        List<String> onlyUppercase = Arrays.stream(scanner.nextLine().split("\\s+")).filter(uppercase).collect(Collectors.toList());

        System.out.println(onlyUppercase.size());

        onlyUppercase.forEach(System.out::println);
    }
}
