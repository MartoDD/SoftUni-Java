package Methods.Lab;

import java.util.Scanner;

public class GreaterOfTwoValues {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();

        switch (type) {
            case "int":
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int result = getMax(a, b);
                System.out.println(result);
                break;
            case "string":
                String ab = scanner.nextLine();
                String ba = scanner.nextLine();
                String output = getMax(ab, ba);
                System.out.println(output);
                break;
            case "char":
                char c = scanner.nextLine().charAt(0);
                char d = scanner.nextLine().charAt(0);
                char bigger = getMax(c, d);
                System.out.println(bigger);
        }

    }

    private static String getMax(String a, String b) {
        if (a.compareTo(b) >= 0) {
            return a;
        }
        return b;
    }

    private static int getMax(int a, int b) {
        return Math.max(a, b);
    }

    private static char getMax(char a, char b) {
        if (a > b) {
            return a;
        }
        return b;
    }
}
