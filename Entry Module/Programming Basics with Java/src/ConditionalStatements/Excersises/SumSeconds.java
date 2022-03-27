package ConditionalStatements.Excersises;

import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int first = scanner.nextInt();
        int second = scanner.nextInt();
        int third = scanner.nextInt();

        int total = first + second + third;
        int totalMinutes = total / 60;
        int totalSeconds = total % 60;

        if (totalMinutes > 0 && totalSeconds >= 10) {
            System.out.println(totalMinutes + ":" + totalSeconds);

        }if (totalMinutes > 0 && totalSeconds < 10) {
            System.out.println(totalMinutes + ":0" + totalSeconds);

        }if (totalMinutes == 0 && totalSeconds >= 10) {
            System.out.println("0" + ":" + totalSeconds);

        }if (totalMinutes == 0 && totalSeconds < 10) {
            System.out.println("0" + ":" + "0" +totalSeconds);

        }
    }
}
