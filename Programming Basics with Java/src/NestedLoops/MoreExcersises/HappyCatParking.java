package NestedLoops.MoreExcersises;

import java.util.Scanner;

public class HappyCatParking {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int days = scanner.nextInt();
        int hours = scanner.nextInt();
        double totalSum=0;
        double sumPerDay=0;

        for (int i = 1; i <= days; i++) {
            for (int j = 1; j <= hours; j++) {
                if (i%2==0 && j%2!=0){
                    sumPerDay+=2.50;
                }else if (i%2!=0 && j%2==0){
                    sumPerDay+=1.25;
                }else {
                    sumPerDay+=1.00;
                }
            }
            totalSum+=sumPerDay;
            System.out.printf("Day: %d - %.2f leva%n",i,sumPerDay);;
            sumPerDay=0;
        }
        System.out.printf("Total: %.2f leva",totalSum);;
    }
}
