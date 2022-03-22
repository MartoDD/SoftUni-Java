package NestedLoops.Lab;

import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String destination = scanner.nextLine();

        while (!destination.equals("End")) {

            double neededBudget = Double.parseDouble(scanner.nextLine());
            double budget = 0;
            while (budget < neededBudget) {

                double money = Double.parseDouble(scanner.nextLine());
                budget += money;
            }
            System.out.println(("Going to ") + destination + "!");

            destination = scanner.nextLine();

        }
    }
}
