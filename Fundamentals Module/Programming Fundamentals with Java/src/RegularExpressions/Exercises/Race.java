package RegularExpressions.Exercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Race {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] participants = scanner.nextLine().split(", ");

        String input = scanner.nextLine();
        Pattern namePattern = Pattern.compile("[a-zA-Z]+");
        Pattern distancePattern = Pattern.compile("[1-9]");
        List<Participant> participan = new ArrayList<>();
        while (!input.equals("end of race")) {
            int sum = 0;
            List<Integer> numbers = new ArrayList<>();
            Matcher nameMatcher = namePattern.matcher(input);
            Matcher distanceMatcher = distancePattern.matcher(input);
            StringBuilder sb = new StringBuilder();
            while (nameMatcher.find()) {
                sb.append(nameMatcher.group());
            }

            while (distanceMatcher.find()) {
                numbers.add(Integer.parseInt(distanceMatcher.group()));
            }
            sum += numbers.stream().mapToInt(integer -> integer).sum();
            for (String s : participants) {
                if (sb.toString().equals(s)) {
                    int finalSum = sum;
                    AtomicBoolean isPresent = new AtomicBoolean(false);
                    participan.forEach(participant -> {
                        {
                            if (sb.toString().equals(participant.getName())) {
                                participant.setDistance(participant.getDistance() + finalSum);
                                isPresent.set(true);
                            }
                        }
                    });
                    if (!isPresent.get()) {
                        Participant participant = new Participant(sb.toString(), sum);
                        participan.add(participant);
                    }
                }
            }
            input = scanner.nextLine();
        }
        participan.sort(Comparator.comparing(Participant::getDistance).reversed());
        System.out.println("1st place: " + participan.get(0).getName());
        System.out.println("2nd place: " + participan.get(1).getName());
        System.out.println("3rd place: " + participan.get(2).getName());
    }

    static class Participant {
        String name;
        int distance;

        public Participant(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
    }

}
