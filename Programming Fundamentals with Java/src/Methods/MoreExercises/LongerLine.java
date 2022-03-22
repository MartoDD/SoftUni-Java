package Methods.MoreExercises;

import java.util.Scanner;

public class LongerLine {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double x1 = scanner.nextInt();
        double y1 = scanner.nextInt();
        double x2 = scanner.nextInt();
        double y2 = scanner.nextInt();
        double a1 = scanner.nextInt();
        double b1 = scanner.nextInt();
        double a2 = scanner.nextInt();
        double b2 = scanner.nextInt();



        printLonger(x1,y1,x2,y2,a1,b1,a2,b2);


    }

    private static void printLonger(double x1, double y1, double x2, double y2, double a1, double b1, double a2, double b2) {

        double firstLineLength=Math.pow(x1-x2,2)+Math.pow(y1-y2,2);
        double secondLineLength=Math.pow(a1-a2,2)+Math.pow(b1-b2,2);

        if (firstLineLength>=secondLineLength){
            Closer(x1,y1,x2,y2);
        }else {
            Closer(a1,b1,a2,b2);
        }
    }

    private static void Closer(double x1, double y1, double x2, double y2) {

        if (x1*x1+y1*y1<=x2*x2+y2*y2){
            System.out.printf("(%.0f, %.0f)(%.0f, %.0f)",x1,y1,x2,y2);
        }else {
            System.out.printf("(%.0f, %.0f)(%.0f, %.0f)",x2,y2,x1,y1);
        }
    }


}
