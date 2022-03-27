package Lists.MoreExercise;

import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        List<Integer> firstList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> newList = new ArrayList<>();
        List<Integer> newerList = new ArrayList<>();

        int bigger = firstList.size() + secondList.size();
        int index = 0;

        for (int i = 0; i < bigger; i++) {
            if (firstList.size() != 0 && secondList.size() != 0) {

                if (i % 2 == 0) {
                    newList.add(firstList.get(index));
                    firstList.remove(index);
                } else {
                    newList.add(secondList.get(secondList.size() - 1));
                    secondList.remove(secondList.size() - 1);
                }
            } else {
                break;
            }
        }
        List<Integer> lastTwoNumbers;

        if (firstList.size() > secondList.size()) {
            lastTwoNumbers = firstList;
        } else {
            lastTwoNumbers = secondList;
        }

        for (Integer value : newList) {

            if (value < Math.max(lastTwoNumbers.get(0), lastTwoNumbers.get(1)) && value > Math.min(lastTwoNumbers.get(0), lastTwoNumbers.get(1))) {
                newerList.add(value);
            }
        }
        Collections.sort(newerList);
        for (Integer integer : newerList) {
            System.out.print(integer + " ");
        }

    }
}
