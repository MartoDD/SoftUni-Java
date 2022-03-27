package Lists.MoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double savings = Double.parseDouble(scanner.nextLine());
        List<Integer> drums = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> outputDrums = new ArrayList<>(drums);


        String input = scanner.nextLine();

        while (!input.equals("Hit it again, Gabsy!")) {

            int hitPower = Integer.parseInt(input);

            for (int i = 0; i < outputDrums.size(); i++) {

                outputDrums.set(i, Math.max(0, outputDrums.get(i) - hitPower));
            }

            int i = 0;

            while (i < outputDrums.size()) {
                if (outputDrums.get(i) == 0) {
                    if (savings - drums.get(i) * 3 >= 0) {
                        savings -= drums.get(i) * 3;
                        outputDrums.set(i, drums.get(i));

                    }
                }
                i++;
            }

            input = scanner.nextLine();
        }
        for (Integer outputDrum : outputDrums) {
            if (outputDrum != 0) {
                System.out.print(outputDrum + " ");
            }
        }
        System.out.println();

        System.out.printf("Gabsy has %.2flv.", savings);
    }
}
