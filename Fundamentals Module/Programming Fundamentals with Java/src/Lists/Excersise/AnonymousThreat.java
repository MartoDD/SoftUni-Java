package Lists.Excersise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("3:1")) {

            String[] instructions = command.split("\\s+");

            switch (instructions[0]) {
                case "merge":
                    int firstIndex = Math.max(0,Integer.parseInt(instructions[1]));
                    int secondIndex = Integer.parseInt(instructions[2]);
                    int count = firstIndex;
                    while (firstIndex < input.size() - 1 && count <= secondIndex - 1) {
                        input.set(firstIndex, input.get(firstIndex) + input.get(firstIndex + 1));
                        input.remove(firstIndex + 1);
                        count++;
                    }
                    break;
                case "divide":
                    List<String> divided = new ArrayList<>();
                    int index = Integer.parseInt(instructions[1]);
                    int partition = Integer.parseInt(instructions[2]);
                    String toBeDivided = input.get(index);
                    int segment = toBeDivided.length() / partition;

                    if (toBeDivided.length() % partition == 0) {
                        for (int i = 0; i < partition; i++) {
                            divided.add(toBeDivided.substring(0, segment));
                            toBeDivided = toBeDivided.substring(segment);
                        }
                    } else {
                        for (int i = 0; i < partition - 1; i++) {
                            divided.add(toBeDivided.substring(0, segment));
                            toBeDivided = toBeDivided.substring(segment);
                        }
                        divided.add(toBeDivided);
                    }
                    input.remove(index);
                    input.addAll(index, divided);
                    break;
            }

            command = scanner.nextLine();
        }
        for (String s : input) {
            System.out.print(s + " ");
        }

    }
}

