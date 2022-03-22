package ConditionalStatements.MoreExcersises;

import java.util.Scanner;

public class Firm {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int neededHours = scanner.nextInt();
        int dayAvailable = scanner.nextInt();
        int employeesOvertime = scanner.nextInt();

        double hoursNoOvertime = (dayAvailable * 0.9) * 8;
        double hoursOvertime = (employeesOvertime * 2) * dayAvailable;
        double totalHours = Math.floor(hoursNoOvertime + hoursOvertime);

        if (neededHours <= totalHours) {
            System.out.printf("Yes!%.0f hours left.", totalHours - neededHours);
        } else {
            System.out.printf("Not enough time!%.0f hours needed.", Math.floor(neededHours - totalHours));
        }
    }
}
