package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        ArrayDeque<Long> stack = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {

            if (i==0 || i==1){
                stack.push(1L);
            }else {
                long numberToAdd=stack.pop();
                long number=stack.pop();
                long toAdd=numberToAdd+number;
                stack.push(numberToAdd);
                stack.push(toAdd);
            }
        }
        System.out.println(stack.pop());
    }
}
