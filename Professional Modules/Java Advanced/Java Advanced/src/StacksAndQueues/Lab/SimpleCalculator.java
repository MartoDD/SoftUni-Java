package StacksAndQueues.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class SimpleCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        Collections.reverse(input);

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String s : input) {
            stack.push(s);
        }

        while (stack.size() > 1) {

            int first = Integer.parseInt(stack.pop());
            String current = stack.pop();
            int second = Integer.parseInt(stack.pop());

            if (current.equals("-")) {
                stack.push(String.valueOf(first - second));
            } else if (current.equals("+")) {
                stack.push(String.valueOf(first + second));
            }
        }
        System.out.println(stack.pop());
    }
}
