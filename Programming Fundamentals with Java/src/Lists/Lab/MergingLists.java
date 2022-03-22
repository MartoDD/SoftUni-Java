package Lists.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        List<Integer> listOne = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> listTwo = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> combined = new ArrayList<>();

        int indexOne = 0;
        int indexTwo = 0;

        for (int i = 0; i < listOne.size() + listTwo.size(); i++) {

            if ((indexOne == indexTwo || indexTwo == listTwo.size()) && indexOne < listOne.size()) {
                combined.add(listOne.get(indexOne));
                indexOne++;
            } else if (indexTwo < listTwo.size()) {
                combined.add(listTwo.get(indexTwo));
                indexTwo++;
            }

        }
        for (Integer i : combined) {
            System.out.print(i + " ");
        }
    }
}
