package NestedLoops.MoreExcersises;

import java.util.Scanner;

public class ChallengeTheWedding {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int male = scanner.nextInt();
        int female = scanner.nextInt();
        int tables = scanner.nextInt();
        int count = 0;
        boolean noMoreTables = false;

        for (int i = 1; i <= male; i++) {
            for (int j = 1; j <= female; j++) {
                count++;
                if (count > tables) {
                    noMoreTables = true;
                    break;
                }
                System.out.printf("(%d <-> %d) ", i, j);
            }
            if (noMoreTables) {
                break;
            }
        }
    }
}
