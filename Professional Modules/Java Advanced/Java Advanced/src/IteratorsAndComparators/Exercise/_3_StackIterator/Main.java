package IteratorsAndComparators.Exercise._3_StackIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Stack stack = new Stack();

        String input = scanner.nextLine();


        while (!input.equals("END")) {

            switch (input.split("\\s+")[0]) {
                case "Push":
                    String[] tokens = input.split("[\\s,]+");
                    for (int i = 1; i < tokens.length; i++) {
                        stack.push(Integer.parseInt(tokens[i]));
                    }
                    break;
                case "Pop":
                    stack.pop();
                    break;
            }


            input = scanner.nextLine();
        }

        stack.forEach(System.out::println);
        stack.forEach(System.out::println);
    }
}
