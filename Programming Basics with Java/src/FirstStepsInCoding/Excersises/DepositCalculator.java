package FirstStepsInCoding.Excersises;

import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double depositSum = Double.parseDouble(scanner.nextLine());
        double depositTimeframe = Double.parseDouble(scanner.nextLine());
        double yearlyInterest = Double.parseDouble(scanner.nextLine());
        double interestMonth = (depositSum * (yearlyInterest/100)) / 12;
        double sum = depositSum + depositTimeframe * interestMonth;
        System.out.println(sum);

    }
}
