package Arrays.Exercise;

import java.util.Scanner;

public class ZigZagArrays {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] first = new String[n];
        String[] second = new String[n];


        for (int i = 0; i < n; i++) {

            String input = scanner.nextLine();
            String[] inputA = input.split(" ");
            if ((i + 1) % 2 == 0) {
                second[i] = inputA[1];
                first[i] = inputA[0];
            } else {
                second[i] = inputA[0];
                first[i] = inputA[1];
            }
        }
        for (String s : second) {
            System.out.print(s + " ");
        }
        System.out.println();

        for (String f : first) {
            System.out.print(f + " ");
        }


    }
}
