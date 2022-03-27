package TextProcessing.Exercise;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        double sum = 0;
        for (String s : input) {
            double number = Double.parseDouble(s.substring(1, s.length() - 1));
            if (s.charAt(0) >= 65 && s.charAt(0) <= 90) {
                number /= s.charAt(0) - 64;
            } else if (s.charAt(0) >= 97 && s.charAt(0) <= 122) {
                number *= s.charAt(0) - 96;
            }

            if (s.charAt(s.length() - 1) >= 65 && s.charAt(s.length() - 1) <= 90) {
                number -= s.charAt(s.length() - 1) - 64;
            } else if (s.charAt(s.length() - 1) >= 97 && s.charAt(s.length() - 1) <= 122) {
                number += s.charAt(s.length() - 1) - 96;
            }
            sum += number;

        }
        System.out.printf("%.2f", sum);

    }
}
