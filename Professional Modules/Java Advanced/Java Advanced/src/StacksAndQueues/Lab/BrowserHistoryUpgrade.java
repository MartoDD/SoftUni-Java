package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!input.equals("Home")) {

            if (!input.equals("back") && !input.equals("forward")) {
                stack.push(input);
                queue.clear();
                System.out.println(stack.peek());
            } else if (input.equals("forward")) {
                if (queue.size() != 0) {
                    System.out.println(queue.poll());
                } else {
                    System.out.println("no next URLs");
                }
            } else {
                if (stack.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    queue.addFirst(stack.pop());
                    System.out.println(stack.peek());
                }
            }
            input = scanner.nextLine();
        }

    }
}
