package ForLoop.Excersises;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#0.00");

        int n = scanner.nextInt();
        int input;
        double p1 = 0;
        double p2 = 0;
        double p3 = 0;
        double p4 = 0;
        double p5 = 0;

        for (int i = 0; i < n; i++) {

            input = scanner.nextInt();

            if (input < 200) {
                p1++;
            } else if (input <= 399) {
                p2++;
            } else if (input <= 599) {
                p3++;
            } else if (input <= 799) {
                p4++;
            } else {
                p5++;
            }
        }
        System.out.println(df.format(p1 / n * 100) + "%" + "\n" + df.format(p2 / n * 100) + "%" + "\n" + df.format(p3 / n * 100) + "%" + "\n" + df.format(p4 / n * 100) + "%" + "\n" + df.format(p5 / n * 100) + "%");
    }
}
