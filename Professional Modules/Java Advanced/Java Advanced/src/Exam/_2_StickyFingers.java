package Exam;

import java.util.Scanner;

public class _2_StickyFingers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        String[][] town = new String[n][n];
        int[] robberPosition=new int[2];
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int j = 0; j < n; j++) {
                if (input[j].equals("D")) {
                    robberPosition[0] = i;
                    robberPosition[1] = j;
                }
                town[i][j] = input[j];
            }
        }
        boolean caught = false;
        for (String command : commands) {

            if (move(robberPosition, command, town)) {
                if (town[robberPosition[0]][robberPosition[1]].equals("$")) {
                    int sum = robberPosition[0] * robberPosition[1];
                    System.out.println("You successfully stole " + sum + "$.");
                    totalSum += sum;
                    town[robberPosition[0]][robberPosition[1]] = "D";
                } else if (town[robberPosition[0]][robberPosition[1]].equals("P")) {
                    town[robberPosition[0]][robberPosition[1]] = "#";
                    caught = true;
                    break;
                } else {
                    town[robberPosition[0]][robberPosition[1]] = "D";
                }
            }
        }

        if (caught) {
            System.out.println("You got caught with " + totalSum + "$, and you are going to jail.");
        } else {
            System.out.println("Your last theft has finished successfully with " + totalSum + "$ in your pocket.");
        }
        printMatrix(town);


    }

    private static void printMatrix(String[][] town) {
        for (String[] strings : town) {
            System.out.println(String.join(" ", strings));
        }
    }

    private static boolean move(int[] robberPosition, String command, String[][] town) {
        switch (command) {
            case "up":
                if (robberPosition[0] == 0) {
                    System.out.println("You cannot leave the town, there is police outside!");
                    return false;
                } else {
                    town[robberPosition[0]][robberPosition[1]] = "+";
                    robberPosition[0]=robberPosition[0]-1;
                }
                break;
            case "down":
                if (robberPosition[0] == town.length - 1) {
                    System.out.println("You cannot leave the town, there is police outside!");
                    return false;
                } else {
                    town[robberPosition[0]][robberPosition[1]] = "+";
                    robberPosition[0]=robberPosition[0]+1;
                }
                break;
            case "left":
                if (robberPosition[1] == 0) {
                    System.out.println("You cannot leave the town, there is police outside!");
                    return false;
                } else {
                    town[robberPosition[0]][robberPosition[1]] = "+";
                    robberPosition[1]=robberPosition[1]-1;
                }
                break;
            case "right":
                if (robberPosition[1] == town.length - 1) {
                    System.out.println("You cannot leave the town, there is police outside!");
                    return false;
                } else {
                    town[robberPosition[0]][robberPosition[1]] = "+";
                    robberPosition[1]=robberPosition[1]+1;
                }
                break;
        }
        return true;
    }
}
