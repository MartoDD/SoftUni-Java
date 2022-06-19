package ExamPreparation.ExamOne;

import java.util.Scanner;

public class _2_Armory {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] armory = new char[n][n];
        int currentRow = 0;
        int currentCol = 0;

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == 'A') {
                    currentRow = i;
                    currentCol = j;
                }
                armory[i][j] = input.charAt(j);
            }
        }
        int money = 0;

        while (true) {
            String input = scanner.nextLine();
            armory[currentRow][currentCol] = '-';

            switch (input) {
                case "down":
                    currentRow++;
                    break;
                case "up":
                    currentRow--;
                    break;
                case "left":
                    currentCol--;
                    break;
                case "right":
                    currentCol++;
                    break;
            }
            if (isInside(currentRow, currentCol, n)) {

                if (armory[currentRow][currentCol] == 'M') {
                    armory[currentRow][currentCol] = '-';
                    currentRow = findCurrentRow(armory);
                    currentCol = findCurrentCol(armory);
                    armory[currentRow][currentCol] = 'A';

                } else if (armory[currentRow][currentCol] != '-') {
                    money += Character.getNumericValue(armory[currentRow][currentCol]);
                    armory[currentRow][currentCol] = 'A';
                }
                if (money >= 65) {
                    System.out.println("Very nice swords, I will come back for more!");
                    System.out.println("The king paid " + money + " gold coins.");
                    break;
                }
            } else {
                System.out.println("I do not need more swords!");
                System.out.println("The king paid " + money + " gold coins.");
                break;
            }

        }
        printMatrix(armory);
    }

    private static int findCurrentCol(char[][] armory) {
        int row = 0;
        int col = 0;
        for (int i = 0; i < armory.length; i++) {
            for (int j = 0; j < armory.length; j++) {
                if (armory[i][j] == 'M') {
                    row = i;
                    col = j;
                }
            }
        }
        return col;
    }

    private static int findCurrentRow(char[][] armory) {
        int row = 0;
        int col = 0;
        for (int i = 0; i < armory.length; i++) {
            for (int j = 0; j < armory.length; j++) {
                if (armory[i][j] == 'M') {
                    row = i;
                    col = j;
                }
            }
        }
        return row;
    }

    private static void printMatrix(char[][] armory) {
        for (char[] chars : armory) {
            for (int j = 0; j < armory.length; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }

    private static boolean isInside(int currentRow, int currentCol, int n) {
        return currentRow < n && currentRow >= 0 && currentCol < n && currentCol >= 0;
    }


}
