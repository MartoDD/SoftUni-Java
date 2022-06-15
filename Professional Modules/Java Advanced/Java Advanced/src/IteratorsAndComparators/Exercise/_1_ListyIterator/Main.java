package IteratorsAndComparators.Exercise._1_ListyIterator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> string=Arrays.stream(input.split("\\s+")).collect(Collectors.toList());
        string.remove(0);
        Listiterator listiterator = new Listiterator(string);

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
            }

            input = scanner.nextLine();
        }
    }
}
