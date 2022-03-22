package Methods.MoreExercises;

import java.util.Scanner;

public class MultiplicationSign {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();


        printPositiveNegativeOrZero(a, b, c);
    }

    private static void printPositiveNegativeOrZero(int a, int b, int c) {
        if (((a * b >0) && (c >0)) || ((a * b <0) && (c <0))){
            System.out.println("positive");
        }else if ((a * b <0) || (c <0)){
            System.out.println("negative");
        }else {
            System.out.println("zero");
        }
    }
}
