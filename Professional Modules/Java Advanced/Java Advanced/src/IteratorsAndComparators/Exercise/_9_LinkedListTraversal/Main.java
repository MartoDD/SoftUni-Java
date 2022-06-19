package IteratorsAndComparators.Exercise._9_LinkedListTraversal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedList<Integer> list = new LinkedList<>();

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            if (input[0].equals("Add")) {
                int numberToAdd = Integer.parseInt(input[1]);
                list.add(numberToAdd);
            } else if (input[0].equals("Remove")) {
                int numberToRemove = Integer.parseInt(input[1]);
                list.remove(numberToRemove);
            }
        }
        System.out.println(list.getSize());
        list.forEach(e -> System.out.print(e + " "));

    }
}
