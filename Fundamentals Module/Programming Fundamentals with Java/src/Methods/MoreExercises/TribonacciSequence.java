package Methods.MoreExercises;

import java.util.Scanner;

public class TribonacciSequence {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();

        int [] trib = new int[a];

        printTribonachi(a, trib);
    }

    private static void printTribonachi(int a, int[] trib) {
        for (int i = 0; i < a; i++) {
            if (i==0 || i==1){
                trib[i]=1;
            }else if (i==2){
                trib[i]=2;
            }else {
                trib[i]= trib[i-2]+ trib[i-1] + trib[i-3];
            }
        }
        for (int t: trib){
            System.out.print(t + " ");
        }
    }
}
