package Lists.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> number = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> endNumbers = new ArrayList<>();
        boolean isEmpty = true;
        for (Integer integer : number) {
            if (integer >= 0) {
                endNumbers.add(integer);
                isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println("empty");
        } else {
            Collections.reverse(endNumbers);
            for (Integer endNumber : endNumbers) {
                System.out.print(endNumber + " ");
            }

        }

    }
}