package NestedLoops.MoreExcersises;

import java.util.Scanner;

public class PrimePairs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int firstBegin= scanner.nextInt();
        int secondBegin= scanner.nextInt();
        int firstDiff= scanner.nextInt();
        int secondDiff= scanner.nextInt();
        boolean firstPrime=true;
        boolean secondPrime=true;

        for (int i = firstBegin; i <=firstBegin+firstDiff ; i++) {
            for (int j = secondBegin; j <=secondBegin+secondDiff ; j++) {
                for (int k = 2; k <=i/2 ; k++) {
                    if (i%k==0){
                        firstPrime=false;
                        break;
                    }
                }
                for (int k = 2; k <=j/2 ; k++) {
                    if (j%k==0){
                        secondPrime=false;
                        break;
                    }
                }
                if ((firstPrime) && (secondPrime)){
                    System.out.println(i + "" + j);

                }
                firstPrime=true;
                secondPrime=true;
            }
        }
    }
}
