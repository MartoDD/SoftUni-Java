package Exam;

import java.util.Scanner;

public class Substitute {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        int l = scanner.nextInt();
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int count = 0;
        boolean reachedSix = false;

        for (int i = k; i <= 8; i++) {
            for (int j = 9; j >= l; j--) {
                for (int o = m; o <= 8; o++) {
                    for (int p = 9; p >= n; p--) {
                        if (i % 2 == 0 && o % 2 == 0 && j % 2 != 0 && p % 2 != 0) {
                            if (i == o && j == p) {
                                System.out.println("Cannot change the same player.");
                            } else {
                                count++;
                                System.out.printf("%d%d - %d%d%n", i, j, o, p);
                            }
                            if (count == 6) {
                                reachedSix = true;
                                break;
                            }
                        }
                        if (reachedSix) {
                            break;
                        }
                    }
                    if (reachedSix) {
                        break;
                    }
                }
                if (reachedSix) {
                    break;
                }
            }
            if (reachedSix) {
                break;
            }
        }
    }
}
