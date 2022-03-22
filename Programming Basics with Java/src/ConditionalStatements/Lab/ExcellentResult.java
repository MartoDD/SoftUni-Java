package ConditionalStatements.Lab;

import java.util.Scanner;

public class ExcellentResult {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int grade = scanner.nextInt();

        if (grade >= 5) {
            System.out.println("Excellent!");
        }
    }
}
