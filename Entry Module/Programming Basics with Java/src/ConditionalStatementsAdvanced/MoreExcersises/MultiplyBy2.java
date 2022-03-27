package ConditionalStatementsAdvanced.MoreExcersises;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MultiplyBy2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#0.00");
        df.setDecimalSeparatorAlwaysShown(true);

        double input = scanner.nextDouble();
        double sum;
        String concatenated = "";

        while (input >= 0) {
            sum = input * 2;
            String sum2 = String.valueOf(df.format(sum));
            concatenated = concatenated + "Result: " + sum2 + "\n";
            input = scanner.nextDouble();
        }
        if (input <= 0 && !concatenated.equals("")) {
            System.out.print(concatenated);
        }
        System.out.print("Negative number!");
    }
}
