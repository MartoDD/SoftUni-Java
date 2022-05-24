package MultidimensionalArrays.Exercises;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _8_TheHeiganDance {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DecimalFormat df = new DecimalFormat("#.##");

        double bossHealth = 3000000;
        double playerHealth = 18500;

        double playerDamagePerTurn = Double.parseDouble(scanner.nextLine());

        int playerRow = 7;
        int playerCol = 7;
        int cloudCounter = 0;
        String lastSpell = "";
        while (bossHealth > 0 && playerHealth > 0) {
            bossHealth -= playerDamagePerTurn;
            if (cloudCounter > 0) {
                playerHealth -= 3500;
                cloudCounter--;
            }
            if (bossHealth <= 0 || playerHealth <= 0) {
                break;
            }


            String[] input = scanner.nextLine().split("\\s+");
            String spell = input[0];
            int row = Integer.parseInt(input[1]);
            int col = Integer.parseInt(input[2]);
            List<Integer> affectedRows = new ArrayList<>();
            addAffected(row, affectedRows);
            List<Integer> affectedCols = new ArrayList<>();
            addAffected(col, affectedCols);


            if (affectedCols.contains(playerCol) || affectedRows.contains(playerRow) || (row == playerRow && col == playerCol)) {
                if (!affectedCols.contains(playerCol) && !affectedRows.contains(playerRow - 1) && !(row == playerRow - 1 && col == playerCol) && playerRow - 1 >= 0) {
                    playerRow--;
                } else if (!affectedCols.contains(playerCol + 1) && !affectedRows.contains(playerRow) && !(row == playerRow && col == playerCol + 1) && playerCol < 15) {
                    playerCol++;
                } else if (!affectedCols.contains(playerCol) && !affectedRows.contains(playerRow + 1) && !(row == playerRow + 1 && col == playerCol) && playerRow + 1 < 15) {
                    playerRow++;
                } else if (!affectedCols.contains(playerCol - 1) && !affectedRows.contains(playerRow) && !(row == playerRow && col == playerCol - 1) && playerCol - 1 >= 0) {
                    playerCol--;
                } else {
                    switch (spell) {
                        case "Cloud":
                            playerHealth -= 3500;
                            cloudCounter = 1;
                            lastSpell = "Plague " + spell;
                            break;
                        case "Eruption":
                            playerHealth -= 6000;
                            lastSpell = spell;
                            break;
                    }
                }
            }
        }
        String boss = bossHealth <= 0 ? "Defeated!" : String.format("%.2f", bossHealth);
        System.out.println("Heigan: " + boss);
        String player = playerHealth <= 0 ? "Killed by " + lastSpell : df.format(playerHealth);
        System.out.println("Player: " + player);
        System.out.println("Final position: " + playerRow + ", " + playerCol);
    }

    private static void addAffected(int row, List<Integer> affectedRows) {
        if (row + 1 < 15) {
            affectedRows.add(row + 1);
        }
        if (row - 1 >= 0) {
            affectedRows.add(row - 1);
        }
    }
}
