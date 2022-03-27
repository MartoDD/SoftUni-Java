package Exam;

import java.util.Scanner;

public class HairSalon {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int target = Integer.parseInt(scanner.nextLine());

        String type = scanner.nextLine();
        int sum = 0;

        while (!type.equals("closed")) {

            String type2 = scanner.nextLine();
            if (type.equals("haircut")) {
                switch (type2) {
                    case "mens":
                        sum += 15;
                        break;
                    case "ladies":
                        sum += 20;
                        break;
                    case "kids":
                        sum += 10;
                        break;
                }
            } else if (type.equals("color")) {
                switch (type2) {
                    case "touch up":
                        sum += 20;
                        break;
                    case "full color":
                        sum += 30;
                        break;
                }
            }
            if (sum >= target) {
                break;
            }

            type = scanner.nextLine();
        }
        if (sum >= target) {
            System.out.println("You have reached your target for the day!");
        } else {
            System.out.printf("Target not reached! You need %dlv. more.%n", target - sum);
        }
        System.out.printf("Earned money: %dlv.", sum);
    }
}
