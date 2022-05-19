package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BasicStackOperations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            stack.push(numbers.get(i));
        }
        for (int i = 0; i < s; i++) {
            stack.pop();
        }
        boolean isPresent = false;
        int smallest = Integer.MAX_VALUE;
        if (stack.size() == 0) {
            System.out.println(0);
        } else {
            while (stack.size() > 0) {
                int current = stack.pop();

                if (smallest > current) {
                    smallest = current;
                }
                if (current == x) {
                    isPresent = true;
                    break;
                }
            }
            if (isPresent) {
                System.out.println("true");
            } else {
                System.out.println(smallest);
            }
        }
    }
}
