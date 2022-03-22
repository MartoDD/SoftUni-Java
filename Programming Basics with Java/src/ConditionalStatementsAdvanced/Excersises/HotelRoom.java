package ConditionalStatementsAdvanced.Excersises;

import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int period = scanner.nextInt();

        double studioPrice = 0;
        double apartPrice = 0;


        switch (month) {
            case "May":
            case "October":
                studioPrice = period * 50;
                apartPrice = period * 65;
                break;
            case "June":
            case "September":
                studioPrice = period * 75.20;
                apartPrice = period * 68.70;
                break;
            case "July":
            case "August":
                studioPrice = period * 76;
                apartPrice = period * 77;
                break;
        }
        if ((period > 7 && period <= 14) && (month.equals("May") || month.equals("October"))) {
            studioPrice *= 0.95;
        } else if ((period > 14) && (month.equals("May") || month.equals("October"))) {
            studioPrice *= 0.70;
        } else if ((period > 14) && (month.equals("June") || month.equals("September"))) {
            studioPrice *= 0.80;
        }
        if (period>14){
            apartPrice *= 0.90;
        }
        System.out.printf("Apartment: %.2f lv.%n", apartPrice);
        System.out.printf("Studio: %.2f lv.", studioPrice);
    }
}
