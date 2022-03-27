package TextProcessing.Exercise;

import java.util.Scanner;

public class CharacterMultiplier {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        System.out.println(sumMultiplied(input[0], input[1]));

    }

    private static Integer sumMultiplied(String s, String s1) {

        int lager = Math.max(s.length(), s1.length());
        int sum = 0;
        for (int i = 0; i < lager; i++) {
            if (i < s.length() && i < s1.length()) {
                sum += s.charAt(i) * s1.charAt(i);
            } else if (s.length() >= s1.length()) {
                sum += s.charAt(i);
            } else {
                sum += s1.charAt(i);
            }

        }

        return sum;
    }
}
