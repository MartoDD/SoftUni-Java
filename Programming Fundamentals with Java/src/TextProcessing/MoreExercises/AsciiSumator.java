package TextProcessing.MoreExercises;

import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char start = scanner.nextLine().charAt(0);
        char end = scanner.nextLine().charAt(0);

        String line = scanner.nextLine();

        int first = Math.min(start, end);
        int last = Math.max(start, end);
        int sum = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) > first && line.charAt(i) < last) {
                sum += line.charAt(i);
            }
        }
        System.out.println(sum);


    }
}
