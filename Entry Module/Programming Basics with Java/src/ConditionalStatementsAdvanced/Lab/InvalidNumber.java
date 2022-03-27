package ConditionalStatementsAdvanced.Lab;

import java.util.Scanner;

public class InvalidNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if ((n < 100 || n > 200) && n != 0) {
            System.out.println("invalid");
        }
    }
}
