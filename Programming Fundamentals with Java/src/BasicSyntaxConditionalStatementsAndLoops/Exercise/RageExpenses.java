package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class RageExpenses {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        double headset = scanner.nextDouble();
        double mouse = scanner.nextDouble();
        double keyboard = scanner.nextDouble();
        double display = scanner.nextDouble();

        int headsetC = 0;
        int mouseC = 0;
        int keyboardC = 0;
        int displayC = 0;
        int anotherKey = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                headsetC++;
            }
            if (i % 3 == 0) {
                mouseC++;
            }
            if (i % 2 == 0 && i % 3 == 0) {
                keyboardC++;
                anotherKey++;
            }
            if (anotherKey % 2 == 0 && anotherKey != 0) {
                displayC++;
                anotherKey = 0;
            }
        }
        double total = headsetC * headset + mouseC * mouse + keyboardC * keyboard + displayC * display;
        System.out.printf("Rage expenses: %.2f lv.", total);
    }
}
