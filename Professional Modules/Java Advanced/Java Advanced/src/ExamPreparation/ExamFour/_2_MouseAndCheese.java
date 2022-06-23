package ExamPreparation.ExamFour;

import java.util.Scanner;

public class _2_MouseAndCheese {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] mouseTerritory = new char[n][n];
        int mouseRow = 0;
        int mouseCol = 0;
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                if (input.charAt(j) == 'M') {
                    mouseRow = i;
                    mouseCol = j;
                }
                mouseTerritory[i][j] = input.charAt(j);
            }
        }
        int mouseCheese = 0;
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            mouseTerritory[mouseRow][mouseCol] = '-';
            switch (input) {
                case "up":
                    mouseRow--;
                    break;
                case "down":
                    mouseRow++;
                    break;
                case "left":
                    mouseCol--;
                    break;
                case "right":
                    mouseCol++;
                    break;
            }
            if (isMouseInside(n, mouseRow, mouseCol)) break;

            if (mouseTerritory[mouseRow][mouseCol]=='B'){
                mouseTerritory[mouseRow][mouseCol]='M';
                continue;
            }

            if (mouseTerritory[mouseRow][mouseCol] == 'c') {
                mouseCheese++;
            }
            mouseTerritory[mouseRow][mouseCol] = 'M';


            input = scanner.nextLine();
        }

        if (mouseCheese<5){
            System.out.println("The mouse couldn't eat the cheeses, she needed " + (5-mouseCheese) + " cheeses more.");
        }else {
            System.out.println("Great job, the mouse is fed " + mouseCheese + " cheeses!");
        }
        printMatrix(mouseTerritory);
    }

    private static void printMatrix(char[][] mouseTerritory) {
        for (char[] chars : mouseTerritory) {
            for (int j = 0; j < mouseTerritory.length; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }

    private static boolean isMouseInside(int n, int mouseRow, int mouseCol) {
        if (!(mouseRow >= 0 && mouseRow < n && mouseCol >= 0 && mouseCol < n)) {
            System.out.println("Where is the mouse?");
            return true;
        }
        return false;
    }

}
