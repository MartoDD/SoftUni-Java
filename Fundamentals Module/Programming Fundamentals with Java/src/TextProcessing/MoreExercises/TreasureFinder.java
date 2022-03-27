package TextProcessing.MoreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] key = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();
        while (!input.equals("find")) {
            StringBuilder sb = new StringBuilder();
            int index = 0;
            for (int i = 0; i < input.length(); i++) {
                char currentChar = (char) (input.charAt(i) - key[index]);
                sb.append(currentChar);
                index++;
                if (index >= key.length) {
                    index = 0;
                }
            }
            int firstIndex = sb.indexOf("&");
            int lastIndex = sb.lastIndexOf("&");
            String type = sb.substring(firstIndex + 1, lastIndex);
            firstIndex = sb.indexOf("<");
            lastIndex = sb.indexOf(">");
            String coordinates = sb.substring(firstIndex + 1, lastIndex);
            System.out.println("Found " + type + " at " + coordinates);


            input = scanner.nextLine();
        }
    }
}
