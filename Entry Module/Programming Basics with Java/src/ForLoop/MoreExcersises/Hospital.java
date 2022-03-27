package ForLoop.MoreExcersises;

import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int period = scanner.nextInt();

        int patients = 0;
        int doctors = 7;
        int treated = 0;
        int untreated = 0;

        for (int i = 1; i <= period; i++) {

            patients = scanner.nextInt();

            if ((i % 3 == 0) && (untreated > treated)) {
                doctors++;
            }
            if (patients > doctors) {
                untreated += patients - doctors;
            }
            treated += Math.min(patients, doctors);
        }
        System.out.println("Treated patients: " + treated + ".");
        System.out.println("Untreated patients: " + untreated + ".");
    }
}
