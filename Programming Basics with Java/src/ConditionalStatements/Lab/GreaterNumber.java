package ConditionalStatements.Lab;

import java.util.Scanner;

public class GreaterNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int greater = Math.max(a,b);

        System.out.println(greater);
    }
}
