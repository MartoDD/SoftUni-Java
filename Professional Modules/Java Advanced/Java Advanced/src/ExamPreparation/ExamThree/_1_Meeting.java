package ExamPreparation.ExamThree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _1_Meeting {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> males = new ArrayDeque<>();
        ArrayDeque<Integer> females = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(males::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(females::offer);

        int countMatches = 0;

        while (males.size() > 0 && females.size() > 0) {
            int male = males.peek();
            int female = females.peek();

            while (male <= 0) {
                males.pop();
                if (males.size() > 0) {
                    male = males.peek();
                } else {
                    break;
                }
            }
            while (female <= 0) {
                females.poll();
                if (females.size() > 0) {
                    female = females.peek();
                } else {
                    break;
                }
            }
            while (male >= 25 && male % 25 == 0) {
                males.pop();
                males.pop();
                if (males.size() > 0) {
                    male = males.peek();
                } else {
                    break;
                }
            }
            while (female >= 25 && female % 25 == 0) {
                females.poll();
                females.poll();
                if (females.size() > 0) {
                    female = females.peek();
                } else {
                    break;
                }
            }
            if (males.size() > 0 && females.size() > 0) {

                if (male == female) {
                    countMatches++;
                    males.pop();
                    females.poll();
                } else {
                    females.poll();
                    male = males.pop() - 2;
                    males.push(male);
                }
            }


        }
        System.out.println("Matches: " + countMatches);
        String malesLeft = males.size() == 0 ? "none" : males.stream().map(Object::toString).collect(Collectors.joining(", "));
        System.out.println("Males left: " + malesLeft);
        String femalesLeft = females.size() == 0 ? "none" : females.stream().map(Object::toString).collect(Collectors.joining(", "));
        System.out.println("Females left: " + femalesLeft);
    }
}
