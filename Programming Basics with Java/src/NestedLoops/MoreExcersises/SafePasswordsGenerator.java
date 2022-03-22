package NestedLoops.MoreExcersises;

import java.util.Scanner;

public class SafePasswordsGenerator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int maxPass = scanner.nextInt();
        char A = 35;
        char B = 64;
        int count = 0;
        boolean isBigger = false;

        for (int x = 1; x <= a; x++) {
            for (int y = 1; y <= b; y++) {
                count++;
                if (count > maxPass) {
                    isBigger = true;
                    break;
                }
                System.out.printf("%c%c%d%d%c%c|", A, B, x, y, B, A);
                A++;
                B++;
                if (A > 55) {
                    A = 35;
                }
                if (B > 96) {
                    B = 64;
                }
            }
            if (isBigger) {
                break;
            }
        }
    }
}
