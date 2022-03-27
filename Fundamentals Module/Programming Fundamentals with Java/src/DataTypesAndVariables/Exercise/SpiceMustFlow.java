package DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class SpiceMustFlow {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int starting = scanner.nextInt();
        int days = 0;
        int totalSpice = 0;

        while (starting >= 100) {
            days++;

            totalSpice += starting;
            if (totalSpice >= 26) {
                totalSpice -= 26;
            } else {
                totalSpice = 0;
            }

            starting -= 10;
        }
        if (totalSpice >= 26) {
            totalSpice -= 26;
        } else {
            totalSpice = 0;
        }
        System.out.println(days);
        System.out.println(totalSpice);
    }
}
