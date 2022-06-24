package ExamPreparation.ExamSix;

import java.util.Scanner;

public class _2_Python {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");
        char[][] field = new char[n][n];
        int[] snakePosition = new int[2];
        int foodCounter = 0;
        int snakeLength = 1;
        boolean isSnakeDead = false;

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            input = input.replaceAll(" ", "");
            for (int j = 0; j < n; j++) {
                if (input.charAt(j) == 'f') {
                    foodCounter++;
                } else if (input.charAt(j) == 's') {
                    snakePosition[0] = i;
                    snakePosition[1] = j;
                }
                field[i][j] = input.charAt(j);

            }
        }

        for (String command : commands) {

            move(command, field, snakePosition);

            if (field[snakePosition[0]][snakePosition[1]] == 'f') {
                foodCounter--;
                snakeLength++;
            } else if (field[snakePosition[0]][snakePosition[1]] == 'e') {
                isSnakeDead = true;
                break;
            }
        }
        if (foodCounter == 0) {
            System.out.println("You win! Final python length is " + snakeLength);
        } else if (isSnakeDead) {
            System.out.println("You lose! Killed by an enemy!");
        } else {
            System.out.println("You lose! There is still " + foodCounter + " food to be eaten.");
        }
    }

    private static void move(String command, char[][] field, int[] snakePosition) {
        switch (command) {
            case "up":
                if (snakePosition[0] == 0) {
                    snakePosition[0] = field.length - 1;
                } else {
                    snakePosition[0]--;
                }
                break;
            case "down":
                if (snakePosition[0] == field.length - 1) {
                    snakePosition[0] = 0;
                } else {
                    snakePosition[0]++;
                }
                break;
            case "left":
                if (snakePosition[1] == 0) {
                    snakePosition[1] = field.length - 1;
                } else {
                    snakePosition[1]--;
                }
                break;
            case "right":
                if (snakePosition[1] == field.length - 1) {
                    snakePosition[1] = 0;
                } else {
                    snakePosition[1]++;
                }
                break;
        }
    }
}
