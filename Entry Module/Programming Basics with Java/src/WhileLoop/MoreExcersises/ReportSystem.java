package WhileLoop.MoreExcersises;

import java.util.Scanner;

public class ReportSystem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int targetSum = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int sales;
        int counter = 0;
        double gatheredSumCard = 0;
        double gatheredSumCash = 0;
        boolean gathered = false;
        int cashCounter = 0;
        int cardCounter = 0;

        while (!input.equals("End")) {

            sales = Integer.parseInt(input);
            counter++;
            if (counter % 2 == 0) {
                if (sales < 10) {
                    System.out.println("Error in transaction!");
                } else {
                    System.out.println("Product sold!");
                    gatheredSumCard += sales;
                    cardCounter++;
                }
            } else {
                if (sales > 100) {
                    System.out.println("Error in transaction!");
                } else {
                    System.out.println("Product sold!");
                    gatheredSumCash += sales;
                    cashCounter++;
                }
            }
            double gatheredSum = gatheredSumCard + gatheredSumCash;
            if (gatheredSum >= targetSum) {
                gathered = true;
                break;
            }

            input = scanner.nextLine();
        }
        double averageCash =gatheredSumCash/cashCounter;
        double averageCard = gatheredSumCard/cardCounter;

        if (gathered){

            System.out.printf("Average CS: %.2f%n", averageCash);
            System.out.printf("Average CC: %.2f",averageCard);
        }else {

            System.out.println("Failed to collect required money for charity.");
        }
    }
}
