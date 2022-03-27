package NestedLoops.MoreExcersises;

import java.util.Scanner;

public class LettersCombinations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char first = scanner.nextLine().charAt(0);
        char last = scanner.nextLine().charAt(0);
        char exception = scanner.nextLine().charAt(0);
        int count = 0;

        for (int i = first; i <= last; i++) {
            for (int j = first; j <= last; j++) {
                for (int k = first; k <= last; k++) {
                    if (i == exception || j == exception || k == exception) {
                        continue;
                    }
                    count++;
                    System.out.printf("%c%c%c ", i, j, k);

                }
            }
        }
        System.out.println(count);
    }
}
