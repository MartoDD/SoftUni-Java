package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _1_SortEvenNumbers {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        List<Integer> number = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());

        System.out.println(number.stream().filter(n -> n % 2 == 0)
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));

        System.out.println(number.stream().filter(n -> n % 2 == 0).sorted().map(String::valueOf).collect(Collectors.joining(", ")));


    }


}


