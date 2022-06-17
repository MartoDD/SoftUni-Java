package IteratorsAndComparators.Exercise._2_Collection;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> string = Arrays.stream(input.split("\\s+")).collect(Collectors.toList());
        string.remove(0);
        Listyiterator listiterator = new Listyiterator(string);

        while (!input.equals("END")) {

            switch (input) {
                case "Move":
                    System.out.println(listiterator.Move());
                    break;
                case "Print":
                    listiterator.print();
                    break;
                case "HasNext":
                    System.out.println(listiterator.hasNext());
                    break;
                case "PrintAll":
                    listiterator.forEach(e -> System.out.print(e + " "));
                    System.out.println();
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
