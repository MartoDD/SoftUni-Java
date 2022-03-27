package DataTypesAndVariables.MoreExercise;

import java.util.Scanner;

public class FromLeftToTheRight {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < n; i++) {
            String numberOne = "";
            String numberTwo = "";
            int temp = 0;
            long sum = 0;
            String input = scanner.nextLine();
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == 32) {
                    break;
                }
                numberOne += input.charAt(j);
                temp = j;
            }
            for (int j = temp + 2; j < input.length(); j++) {
                numberTwo += input.charAt(j);
            }
            long one = Long.parseLong(numberOne);
            long two = Long.parseLong(numberTwo);
            if (one >= two) {
                while (Math.abs(one) > 0) {
                    long digit = Math.abs(one % 10);
                    sum += digit;
                    one /= 10;
                }
            } else {
                while (Math.abs(two) > 0) {
                    long digit = Math.abs(two % 10);
                    sum += digit;
                    two /= 10;
                }
            }
            System.out.println(sum);

        }
    }
}
