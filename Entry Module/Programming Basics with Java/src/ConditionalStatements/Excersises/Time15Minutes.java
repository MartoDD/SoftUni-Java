package ConditionalStatements.Excersises;

import java.util.Scanner;

public class Time15Minutes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int hour = scanner.nextInt();
        int minutes = scanner.nextInt();
        int totalMinutes = hour * 60 + minutes;
        int timeAfter15Minutes = totalMinutes + 15;

        int endHours = timeAfter15Minutes / 60;
        int endMinutes = timeAfter15Minutes % 60;

        if (endHours >= 24) {
            endHours %= 24;
        }
        if (endMinutes < 10) {
            System.out.printf("%d:0%d", endHours, endMinutes);
        } else {
            System.out.printf("%d:%d", endHours, endMinutes);
        }


    }
}
