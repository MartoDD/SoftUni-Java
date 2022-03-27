package TextProcessing.Exercise;

import java.util.Scanner;

public class MultiplyBigNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String bigNumber = scanner.nextLine();
        int multiplier = Integer.parseInt(scanner.nextLine());
        int remainder = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = bigNumber.length() - 1; i >= 0; i--) {

            int digit = Integer.parseInt(String.valueOf(bigNumber.charAt(i)));
            int product = digit * multiplier + remainder;
            if (i != 0) {
                if (product > 9) {
                    remainder = product / 10;
                    product %= 10;
                } else {
                    remainder = 0;
                }
            }
            sb.insert(0, product);
        }
        while (sb.charAt(0) == '0' && sb.length()>1) {
                sb.deleteCharAt(0);
            }

        System.out.println(sb);
    }
}
