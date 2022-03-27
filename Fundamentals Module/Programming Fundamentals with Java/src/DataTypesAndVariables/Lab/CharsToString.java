package DataTypesAndVariables.Lab;

import java.util.Scanner;

public class CharsToString {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();
        String b = scanner.nextLine();
        String c = scanner.nextLine();

        String out = a + b + c;

        System.out.println(out);
    }
}
