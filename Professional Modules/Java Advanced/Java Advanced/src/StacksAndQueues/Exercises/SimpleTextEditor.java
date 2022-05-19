package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {

            String[] input = scanner.nextLine().split("\\s+");

            switch (input[0]) {
                case "1":
                    String temp = sb.toString();
                    stack.push(temp);
                    sb.append(input[1]);
                    break;
                case "2":
                    int count = Integer.parseInt(input[1]);
                    int startIndex = sb.length() - count;
                    String tp = sb.toString();
                    stack.push(tp);
                    sb.delete(startIndex, sb.length());
                    break;
                case "3":
                    int index = Integer.parseInt(input[1]);
                    System.out.println(sb.toString().charAt(index - 1));
                    break;
                case "4":
                    sb = new StringBuilder(stack.pop());
                    break;
            }

        }
    }
}
