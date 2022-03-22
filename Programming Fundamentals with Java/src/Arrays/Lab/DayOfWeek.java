package Arrays.Lab;

import java.util.Scanner;

public class DayOfWeek {

    public static void main(String[] args) {

        String[] day = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if (n >= 1 && n <= 7) {
            System.out.println(day[n-1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
