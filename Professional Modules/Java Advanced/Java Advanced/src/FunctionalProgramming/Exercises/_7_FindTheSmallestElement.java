package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _7_FindTheSmallestElement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> smallestNumberIndex = list -> {
            int smallest = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < list.size(); i++) {
                Integer integer = list.get(i);
                if (integer <= smallest) {
                    smallest = integer;
                    index = i;
                }
            }
            return index;
        };

        System.out.println(smallestNumberIndex.apply(numbers));
    }
}
