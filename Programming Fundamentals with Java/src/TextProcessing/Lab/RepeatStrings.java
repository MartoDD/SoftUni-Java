package TextProcessing.Lab;

import java.util.Scanner;

public class RepeatStrings {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        for (String s : input) {
            int counts = s.length();

            for (int i = 0; i < counts; i++) {
                System.out.print(s);
            }
        }

    }
}
