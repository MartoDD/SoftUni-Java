package ConditionalStatementsAdvanced.MoreExcersises;

import java.util.Scanner;

public class BikeRace {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int junior = Integer.parseInt(scanner.nextLine());
        int senior = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        double juniorIncome = 0;
        double seniorIncome = 0;
        double totalIncome;

        switch (type) {
            case "trail":
                juniorIncome = 5.50 * junior;
                seniorIncome = 7.00 * senior;
                break;
            case "cross-country":
                juniorIncome = 8.00 * junior;
                seniorIncome = 9.50 * senior;
                break;
            case "downhill":
                juniorIncome = 12.25 * junior;
                seniorIncome = 13.75 * senior;
                break;
            case "road":
                juniorIncome = 20.00 * junior;
                seniorIncome = 21.50 * senior;
                break;
        }
        double sum = juniorIncome + seniorIncome;

        if ((junior + senior >= 50) && type.equals("cross-country")) {
            sum *= 0.75;
        }
        totalIncome = sum * 0.95;
        System.out.printf("%.2f", totalIncome);
    }
}
