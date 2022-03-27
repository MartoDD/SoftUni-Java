package ForLoop.Excersises;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TrekkingMania {
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
        int totalPpl = 0;

        for (int i = 0; i < n; i++) {

            input = scanner.nextInt();
            totalPpl += input;
            if (input <= 5) {
                p1 += input;
            } else if (input <= 12) {
                p2 += input;
            } else if (input <= 25) {
                p3 += input;
            } else if (input <= 40) {
                p4 += input;
            } else {
                p5 += input;
            }
        }
        System.out.println(df.format(p1 / totalPpl * 100) + "%" + "\n" + df.format(p2 / totalPpl * 100) + "%" + "\n" + df.format(p3 / totalPpl * 100) + "%" + "\n" + df.format(p4 / totalPpl * 100) + "%" + "\n" + df.format(p5 / totalPpl * 100) + "%");
    }
}
