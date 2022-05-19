package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> stackOpening = new ArrayDeque<>();
        boolean isBalanced = true;

        for (int i = 0; i < input.length(); i++) {

            char currentBracket = input.charAt(i);

            if (currentBracket == '{' || currentBracket == '[' || currentBracket == '(') {
                stackOpening.push(currentBracket);
            } else {
                if (!stackOpening.isEmpty()) {
                    char openingBracket = stackOpening.pop();

                    if (currentBracket == '}' && openingBracket != '{') {
                        isBalanced = false;
                    } else if (currentBracket == ']' && openingBracket != '[') {
                        isBalanced = false;
                    } else if (currentBracket == ')' && openingBracket != '(') {
                        isBalanced = false;
                    }
                } else {
                    isBalanced = false;
                }
            }
        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
