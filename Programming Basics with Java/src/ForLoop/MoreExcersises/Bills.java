package ForLoop.MoreExcersises;

import java.util.Scanner;

public class Bills {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        double electricity = 0;
        double electricityTotal = 0;
        double water = 0;
        double internet = 0;
        double others = 0;

        for (int i = 0; i < n; i++) {

            electricity = scanner.nextDouble();
            electricityTotal += electricity;
            water += 20;
            internet += 15;
            others += (electricity + 20 + 15) * 1.20;
        }
        double avg = (electricityTotal + water + internet + others) / n;
        System.out.printf("Electricity: %.2f lv%n", electricityTotal);
        System.out.printf("Water: %.2f lv%n", water);
        System.out.printf("Internet: %.2f lv%n", internet);
        System.out.printf("Other: %.2f lv%n", others);
        System.out.printf("Average: %.2f lv%n", avg);
    }
}
