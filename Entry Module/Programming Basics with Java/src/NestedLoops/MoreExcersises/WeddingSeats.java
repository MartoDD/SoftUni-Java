package NestedLoops.MoreExcersises;

import java.util.Scanner;

public class WeddingSeats {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char lastSector = scanner.nextLine().charAt(0);
        int rows = Integer.parseInt(scanner.nextLine());
        int seats = Integer.parseInt(scanner.nextLine());
        int count = 0;


        for (int i = 65; i <= lastSector; i++) {
            for (int j = 1; j <= rows + i - 65; j++) {
                if (j % 2 == 0) {
                    for (int k = 97; k <= seats + 96 + 2; k++) {
                        count++;
                        System.out.printf("%c%d%c%n", i, j, k);
                    }
                } else {
                    for (int k = 97; k <= seats + 96; k++) {
                        count++;
                        System.out.printf("%c%d%c%n", i, j, k);
                    }
                }
            }
        }
        System.out.println(count);
    }
}
