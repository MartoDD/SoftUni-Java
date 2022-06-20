package ExamPreparation.ExamTwo;

import java.util.Scanner;

public class _2_PawnWars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int whiteRow = 0;
        int whiteCol = 0;
        int blackRow = 0;
        int blackCol = 0;
        char[][] chess = new char[8][8];

        for (int i = 0; i < 8; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < 8; j++) {
                chess[i][j] = input.charAt(j);
                if (input.charAt(j) == 'w') {
                    whiteRow = i;
                    whiteCol = j;
                } else if (input.charAt(j) == 'b') {
                    blackRow = i;
                    blackCol = j;
                }

            }
        }
        while (true) {
            boolean whiteTakes = checkIfTakes(whiteRow, whiteCol, chess);
            if (whiteTakes) {
                String position = getPosition(blackRow, blackCol);
                System.out.println("Game over! White capture on " + position + ".");
                break;
            }
            chess[whiteRow][whiteCol] = '-';
            whiteRow--;
            if (whiteRow == 0) {
                String position = getPosition(whiteRow, whiteCol);
                System.out.println("Game over! White pawn is promoted to a queen at " + position + ".");
                break;
            } else {
                chess[whiteRow][whiteCol] = 'w';
            }
            boolean blackTakes = checkIfTakesBlack(blackRow, blackCol, chess);
            if (blackTakes) {
                String position = getPosition(whiteRow, whiteCol);
                System.out.println("Game over! Black capture on " + position + ".");
                break;
            }

            chess[blackRow][blackCol] = '-';
            blackRow++;
            if (blackRow == 7) {
                String position = getPosition(blackRow, blackCol);
                System.out.println("Game over! Black pawn is promoted to a queen at " + position + ".");
                break;
            } else {
                chess[blackRow][blackCol] = 'b';
            }
        }

    }

    private static boolean checkIfTakesBlack(int blackRow, int blackCol, char[][] chess) {

        if (blackCol == 0) {
            return chess[blackRow + 1][blackCol + 1] == 'w';
        } else if (blackCol == 7) {
            return chess[blackRow + 1][blackCol - 1] == 'w';
        } else {
            return chess[blackRow + 1][blackCol - 1] == 'w' || chess[blackRow + 1][blackCol + 1] == 'w';
        }
    }

    private static boolean checkIfTakes(int whiteRow, int whiteCol, char[][] chess) {
        if (whiteCol == 0) {
            return chess[whiteRow - 1][whiteCol + 1] == 'b';
        } else if (whiteCol == 7) {
            return chess[whiteRow - 1][whiteCol - 1] == 'b';
        } else {
            return chess[whiteRow - 1][whiteCol - 1] == 'b' || chess[whiteRow - 1][whiteCol + 1] == 'b';
        }
    }

    private static String getPosition(int whiteRow, int whiteCol) {
        String col = "";
        switch (whiteCol) {
            case 0:
                col = "a";
                break;
            case 1:
                col = "b";
                break;
            case 2:
                col = "c";
                break;
            case 3:
                col = "d";
                break;
            case 4:
                col = "e";
                break;
            case 5:
                col = "f";
                break;
            case 6:
                col = "g";
                break;
            case 7:
                col = "h";
                break;
        }
        String row = "";
        switch (whiteRow) {
            case 0:
                row = "8";
                break;
            case 1:
                row = "7";
                break;
            case 2:
                row = "6";
                break;
            case 3:
                row = "5";
                break;
            case 4:
                row = "4";
                break;
            case 5:
                row = "3";
                break;
            case 6:
                row = "2";
                break;
            case 7:
                row = "1";
                break;
        }
        return col + row;
    }
}
