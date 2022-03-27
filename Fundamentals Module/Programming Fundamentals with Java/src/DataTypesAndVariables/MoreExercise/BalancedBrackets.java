package DataTypesAndVariables.MoreExercise;

import java.util.Scanner;

public class BalancedBrackets {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        boolean isOpened = false;
        boolean isBalanced = false;

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            if (input.equals("(") && isOpened) {
                break;
            } else if (input.equals("(")) {
                isOpened = true;
                isBalanced=false;
            }

            if (input.equals(")") && isOpened) {
                isOpened = false;
                isBalanced = true;
            } else if (input.equals(")")) {
                isBalanced = false;
                break;
            }
        }
        if (isBalanced) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }

    }
}
