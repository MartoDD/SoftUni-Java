package ConditionalStatementsAdvanced.Excersises;

import java.util.Scanner;

public class OnTimeForTheExam {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int examHour = scanner.nextInt() * 60;
        int examMinute = scanner.nextInt();
        int arrivalHour = scanner.nextInt() * 60;
        int arrivalMinute = scanner.nextInt();

        int examTotal = examHour + examMinute;
        int arrivalTotal = arrivalHour + arrivalMinute;

        int hours;
        int minutes;

        if (examTotal < arrivalTotal) {
            hours = (arrivalTotal - examTotal) / 60;
            minutes = (arrivalTotal - examTotal) % 60;
            if (hours != 0) {
                if (minutes == 0) {
                    System.out.printf("Late%n%d:%d0 hours after the start", hours, minutes);
                } else if (minutes < 9) {
                    System.out.printf("Late%n%d:0%d hours after the start", hours, minutes);
                } else {
                    System.out.printf("Late%n%d:%d hours after the start", hours, minutes);
                }

            } else {
                System.out.printf("Late%n%d minutes after the start", minutes);
            }
        } else if (examTotal > arrivalTotal) {
            hours = (examTotal - arrivalTotal) / 60;
            minutes = (examTotal - arrivalTotal) % 60;

            if (hours == 0) {
                if (minutes <= 30) {
                    System.out.printf("On time%n%d minutes before the start", minutes);
                } else {
                    System.out.printf("Early%n%d minutes before the start", minutes);
                }
            } else {
                if (minutes == 0) {
                    System.out.printf("Early%n%d:%d0 hours before the start", hours, minutes);
                } else if (minutes < 9) {
                    System.out.printf("Early%n%d:0%d hours before the start", hours, minutes);
                } else {
                    System.out.printf("Early%n%d:%d hours before the start", hours, minutes);
                }
            }
        } else {
            System.out.println("On time");
        }
    }
}

