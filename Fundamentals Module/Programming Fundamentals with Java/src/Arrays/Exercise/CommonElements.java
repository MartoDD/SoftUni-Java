package Arrays.Exercise;

import java.util.Scanner;

public class CommonElements {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] firstArr = input.split(" ");
        input = scanner.nextLine();
        String[] secondArr = input.split(" ");
        StringBuilder output = new StringBuilder();


        for (String s : secondArr) {
            for (String value : firstArr) {
                if (s.equals(value)) {
                    output.append(s).append(" ");
                }
            }

        }
        System.out.println(output);

    }
}
