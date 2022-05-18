package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> queueOfStrings = new ArrayDeque<>();

        while (!input.equals("print")) {

            if (!input.equals("cancel")) {
                queueOfStrings.offer(input);
            } else {
                if (queueOfStrings.size() != 0) {
                    System.out.println("Canceled " + queueOfStrings.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            }
            input = scanner.nextLine();
        }
        for (String queueOfString : queueOfStrings) {
            System.out.println(queueOfString);
        }

    }
}
