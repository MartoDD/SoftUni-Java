package ExamPreparation.ExamFive;

import java.util.Scanner;

public class _2_FormulaOne {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int countOfCommand = Integer.parseInt(scanner.nextLine());
        boolean won = false;

        char[][] track = new char[n][n];
        int playerRow = 0;
        int playerCol = 0;

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                if (input.charAt(j) == 'P') {
                    playerRow = i;
                    playerCol = j;
                }
                track[i][j] = input.charAt(j);
            }
        }


        for (int i = 0; i < countOfCommand; i++) {
            String input = scanner.nextLine();
            int originalRow = playerRow;
            int originalCol = playerCol;


            switch (input) {
                case "up":
                    playerRow--;
                    break;
                case "down":
                    playerRow++;
                    break;
                case "left":
                    playerCol--;
                    break;
                case "right":
                    playerCol++;
                    break;
            }
            if (!(playerCol >= 0 && playerCol < n && playerRow >= 0 && playerRow < n)) {
                playerRow = changeRow(playerRow, n);
                playerCol = changeCol(playerCol, n);
            }
            if (track[playerRow][playerCol] == 'B') {
                track[originalRow][originalCol] = '.';
                switch (input) {
                    case "up":
                        playerRow--;
                        break;
                    case "down":
                        playerRow++;
                        break;
                    case "left":
                        playerCol--;
                        break;
                    case "right":
                        playerCol++;
                        break;
                }
                if (!(playerCol >= 0 && playerCol < n && playerRow >= 0 && playerRow < n)) {
                    playerRow = changeRow(playerRow, n);
                    playerCol = changeCol(playerCol, n);
                }
            } else if (track[playerRow][playerCol] == 'T') {
                playerRow = originalRow;
                playerCol = originalCol;

            } else if (track[playerRow][playerCol] == 'F') {
                track[originalRow][originalCol] = '.';
                track[playerRow][playerCol] = 'P';
                won = true;
                break;
            } else {
                track[originalRow][originalCol] = '.';
                track[playerRow][playerCol] = 'P';
            }
        }
        if (won) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        printMatrix(track);
    }

    private static void printMatrix(char[][] track) {
        for (char[] chars : track) {
            for (int j = 0; j < track.length; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }

    private static int changeCol(int playerCol, int n) {
        if (playerCol >= n) {
            playerCol = 0;
        } else if (playerCol < 0) {
            playerCol = n - 1;
        }
        return playerCol;
    }

    private static int changeRow(int playerRow, int n) {
        if (playerRow >= n) {
            playerRow = 0;
        } else if (playerRow < 0) {
            playerRow = n - 1;
        }
        return playerRow;

    }
}
