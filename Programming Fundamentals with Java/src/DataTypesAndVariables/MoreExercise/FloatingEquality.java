package DataTypesAndVariables.MoreExercise;

import java.util.Scanner;

public class FloatingEquality {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();

        double esp = 0.000001;

        if (Math.abs(a-b)<esp){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }
}
