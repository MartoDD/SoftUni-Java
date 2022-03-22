package Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[] field = new int[size];

        int[] ladyBugs = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int ladyBug : ladyBugs) {
            if ((ladyBug < size) && (ladyBug>=0)) {
                field[ladyBug] = 1;
            }
        }

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            String[] change = input.split(" ");
            int index = Integer.parseInt(change[0]);
            int distance = Integer.parseInt(change[2]);
            String command = change[1];

            if (((index >= size) || (index <0)) ||  (field[index]!=1)) {
                input = scanner.nextLine();
                continue;
            }

            field[index] = 0;
            int tem = 1;
            switch (command) {
                case "right":
                    while ((tem == 1) && ((index + distance) < size) && (index + distance >= 0)) {

                        if (field[index + distance] != 1) {
                            field[index + distance] = 1;
                            tem = 0;
                        } else {
                            if (distance > 0) {
                                distance+=distance;
                            } else {
                                distance-=distance;
                            }
                        }
                    }
                    break;
                case "left":
                    while ((tem == 1) && ((index - distance) >= 0) && (index - distance < size)) {

                        if (field[index - distance] != 1) {
                            field[index - distance] = 1;
                            tem = 0;
                        } else {
                            if (distance > 0) {
                                distance+=distance;
                            } else {
                                distance-=distance;
                            }
                        }
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        for (int n : field) {
            System.out.print(n + " ");
        }
    }
}
