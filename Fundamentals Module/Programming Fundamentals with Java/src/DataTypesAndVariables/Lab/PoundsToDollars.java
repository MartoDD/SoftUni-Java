package DataTypesAndVariables.Lab;

import java.util.Scanner;

public class PoundsToDollars {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double pounds = scanner.nextDouble();
        double dollars = pounds * 1.36;

        System.out.printf("%.3f", dollars);
    }
}
