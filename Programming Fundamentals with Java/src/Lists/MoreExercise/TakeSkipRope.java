package Lists.MoreExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());

        List<Integer> allNumbers = new ArrayList<>();

        extractNumbersInASeparateList(input, allNumbers);
        removeNumbers(input);

        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();

        for (int i = 0; i < allNumbers.size(); i++) {

            if (i % 2 != 0) {
                skipList.add(allNumbers.get(i));
            } else {
                takeList.add(allNumbers.get(i));
            }
        }

        StringBuilder output = new StringBuilder();
        int currentIndex = 0;
        int takeListIndex = 0;
        int skipListIndex = 0;

        for (int i = 0; i < takeList.size() + skipList.size(); i++) {
            int value;

            if (i % 2 == 0) {
                value = takeList.get(takeListIndex);
                takeListIndex++;
                for (int j = 0; j < value; j++) {
                    if (currentIndex < input.length()) {


                        output.append(input.charAt(currentIndex));
                        currentIndex++;
                    }
                }
            } else {
                value = skipList.get(skipListIndex);
                skipListIndex++;
                for (int j = 0; j < value; j++) {
                    currentIndex++;

                }
            }
        }

        System.out.println(output);


    }

    private static void extractNumbersInASeparateList(StringBuilder input, List<Integer> allNumbers) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 48 && input.charAt(i) <= 57) {
                int number = Integer.parseInt(String.valueOf(input.charAt(i)));
                allNumbers.add(number);

            }
        }
    }

    private static void removeNumbers(StringBuilder input) {
        int i = 0;
        while (i < input.length()) {
            if (input.charAt(i) >= 48 && input.charAt(i) <= 57) {
                input.deleteCharAt(i);

            } else {
                i++;
            }
        }
    }
}
