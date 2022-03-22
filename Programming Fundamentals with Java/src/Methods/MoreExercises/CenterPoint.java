package Methods.MoreExercises;

import java.util.Scanner;

public class CenterPoint {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int x1= scanner.nextInt();
        int y1= scanner.nextInt();
        int x2= scanner.nextInt();
        int y2= scanner.nextInt();

        printCloserToTheZero(x1, y1, x2, y2);


    }

    private static void printCloserToTheZero(int x1, int y1, int x2, int y2) {
        if (Math.abs(x1 + y1)>Math.abs(x2 + y2)){
            System.out.printf("(%d, %d)", x2, y2);
        }else {
            System.out.printf("(%d, %d)", x1, y1);
        }
    }
}
