package FirstStepsInCoding.Excersises;

import java.util.Scanner;

public class BasketballEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int yearlyTax = Integer.parseInt(scanner.nextLine());
        double sneakers = yearlyTax - yearlyTax * 0.40;
        double uniform = sneakers - sneakers * 0.20;
        double ball = uniform / 4;
        double accessories = ball / 5;

        double totalExpenses = sneakers + uniform + ball + accessories + yearlyTax;

        System.out.println(totalExpenses);

    }
}
