package Temp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {

            String[] input = scanner.nextLine().split("\\s+");

            switch (input[0]) {
                case "Create":
                    if (input.length==5){
                        Pet pet = new Pet(input[2],Integer.parseInt(input[3]),input[4]);

                    }else if (input.length==4){
                        if (Integer.parseInt(input[3])%2!=0){
                            Clinic clinic = new Clinic(input[2],Integer.parseInt(input[3]));
                        }else {
                            System.out.println("Invalid Operation!");
                        }

                    }else {
                        System.out.println("Invalid Operation!");
                    }
                    break;
                case "Add":
                    break;
                case "Release":
                    break;
                case "HasEmptyRooms":
                    break;
                case "Print":
                    break;

            }
        }
    }
}
