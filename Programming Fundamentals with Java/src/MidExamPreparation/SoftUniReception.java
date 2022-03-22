package MidExamPreparation;

import java.util.Scanner;

public class SoftUniReception {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int totalStudents = scanner.nextInt();

        int currentStudents = 0;
        int hoursAccumulated = 0;

        while (currentStudents < totalStudents) {

            currentStudents += a + b + c;
            hoursAccumulated++;
            if (hoursAccumulated % 4 == 0) {
                hoursAccumulated++;
            }
        }

        System.out.printf("Time needed: %dh.", hoursAccumulated);


    }
}
