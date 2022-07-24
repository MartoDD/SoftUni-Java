package ExceptionsAndErrorHandling;

import java.util.Scanner;

public class _2_SquareRoot {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String numberAsString= scanner.nextLine();
        double n = -1;

        try {
           n=sqrt(Integer.parseInt(numberAsString));
        }catch (IllegalArgumentException e){
            System.out.println("Invalid");
        }

        if (n!=-1){
            System.out.printf("%.2f%n",n);
        }
        System.out.println("Goodbye");


    }

    private static double sqrt(int n) {
        if (n<0){
            throw new IllegalArgumentException("Invalid");
        }
        return Math.sqrt(n);
    }
}
