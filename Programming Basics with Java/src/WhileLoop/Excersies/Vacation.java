package WhileLoop.Excersies;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double neededMoney = Double.parseDouble(scanner.nextLine());
        double availableMoney = Double.parseDouble(scanner.nextLine());

        String action;
        double amount;
        int spendCount = 0;
        int dayCount = 0;
        boolean gathered = true;

        do {
            action = scanner.nextLine();
            amount = Double.parseDouble(scanner.nextLine());

            dayCount++;

            if (action.equals("spend")) {
                availableMoney -= amount;
                if (availableMoney < 0) {
                    availableMoney = 0;
                }
                spendCount++;
            } else {
                availableMoney += amount;
                spendCount = 0;
            }
            if (spendCount == 5) {
                System.out.println("You can't save the money.");
                System.out.printf("%d", dayCount);
                gathered = false;
                break;
            }

        } while (availableMoney < neededMoney);
        if (gathered) {
            System.out.printf("You saved the money for %d days.", dayCount);
        }
    }
}
