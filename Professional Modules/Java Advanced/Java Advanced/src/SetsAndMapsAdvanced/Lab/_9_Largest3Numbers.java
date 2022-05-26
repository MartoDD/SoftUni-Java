package SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _9_Largest3Numbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> integers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        integers.stream().sorted((n1, n2) -> n2.compareTo(n1)).limit(3).forEach(integer -> System.out.print(integer + " "));


    }
}
