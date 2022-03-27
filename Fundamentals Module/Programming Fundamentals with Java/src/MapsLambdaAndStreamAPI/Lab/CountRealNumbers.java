package MapsLambdaAndStreamAPI.Lab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> number = Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).collect(Collectors.toList());

        TreeMap<Double, Integer> counts = new TreeMap<>();

        for (Double aDouble : number) {
            if (!counts.containsKey(aDouble)) {
                counts.put(aDouble, 0);
            }
            counts.put(aDouble, counts.get(aDouble) + 1);
        }

        for (Map.Entry<Double, Integer> doubleIntegerEntry : counts.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.#######");
            System.out.printf("%s -> %s%n", df.format(doubleIntegerEntry.getKey()), df.format(doubleIntegerEntry.getValue()));
        }


    }
}
