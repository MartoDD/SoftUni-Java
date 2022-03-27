package NestedLoops.MoreExcersises;

import java.util.Scanner;

public class TheSongOfTheWheels {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int control = scanner.nextInt();
        String password = "";
        int counter = 0;

        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                for (int c = 1; c <= 9; c++) {
                    for (int d = 1; d <= 9; d++) {
                        if ((a * b + c * d == control) && a < b && c > d) {
                            counter++;
                            System.out.printf("%d%d%d%d ", a, b, c, d);
                            if (counter == 4) {
                                password += a + "" + b + "" + c + "" + d;
                            }
                        }
                    }
                }
            }
        }
        if (password.equals("")) {
            System.out.println("\nNo!");
        } else {
            System.out.printf("%nPassword: %s", password);
        }
    }
}
