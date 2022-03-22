package NestedLoops.Lab;

import java.util.Scanner;

public class Building {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int floorCount= scanner.nextInt();
        int roomCount = scanner.nextInt();

        for (int i = floorCount; i >=1 ; i--) {
            for (int j = 0; j <roomCount ; j++) {
                if (i==floorCount){
                    System.out.print("L" + i+j + " ");
                }else if (i%2==0) {
                    System.out.print("O" + i+j + " ");
                }else {
                    System.out.print("A" + i+j + " ");
                }
            }
            System.out.println();
        }
    }
}
