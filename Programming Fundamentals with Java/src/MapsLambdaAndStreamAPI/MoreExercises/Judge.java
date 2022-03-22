package MapsLambdaAndStreamAPI.MoreExercises;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Judge {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<User>> everybody = new LinkedHashMap<>();
        List<User> individual = new ArrayList<>();

        while (!input.equals("no more time")) {
            AtomicBoolean isPresent = new AtomicBoolean(false);
            AtomicBoolean existInList = new AtomicBoolean(false);
            String[] info = input.split(" -> ");
            everybody.putIfAbsent(info[1], new ArrayList<>());
            User user = new User(info[0], Integer.parseInt(info[2]), info[1]);

            everybody.get(info[1]).forEach(user1 -> {
                if (user1.getName().equals(info[0])) {
                    if (user1.getScore() < Integer.parseInt(info[2])) {
                        user1.setScore(Integer.parseInt(info[2]));
                    }
                    isPresent.set(true);
                }
            });
            if (!isPresent.get()) {
                everybody.get(info[1]).add(user);
            }

            User userIndividual = new User(info[0], Integer.parseInt(info[2]), info[1]);
            individual.forEach(user1 -> {
                if (user1.getName().equals(info[0]) && !user1.getContest().equals(info[1])) {
                    user1.setScore(user1.getScore() + Integer.parseInt(info[2]));
                    existInList.set(true);
                } else if (user1.getName().equals(info[0]) && user1.getContest().equals(info[1])) {
                    if (user1.getScore() < Integer.parseInt(info[2])) {
                        user1.setScore(Integer.parseInt(info[2]));
                    }
                    existInList.set(true);
                }
            });
            if (!existInList.get()) {
                individual.add(userIndividual);
            }
            input = scanner.nextLine();
        }
        everybody.forEach((k, v) -> {
            System.out.println(k + ": " + v.size() + " participants");
            AtomicInteger countOne = new AtomicInteger();
            v.sort(Comparator.comparing(User::getName));
            v.sort(Comparator.comparing(User::getScore).reversed());
            v.forEach(user -> {
                countOne.getAndIncrement();
                System.out.println(countOne + ". " + user.print());
            });
        });
        AtomicInteger count = new AtomicInteger();
        System.out.println("Individual standings:");
        individual.sort(Comparator.comparing(User::getName));
        individual.sort(Comparator.comparing(User::getScore).reversed());
        individual.forEach(user -> {
            count.getAndIncrement();
            System.out.println(count + ". " + user.printIndividual());
        });

    }

    static class User {
        String name;
        Integer score;
        String contest;

        public User(String name, Integer score, String contest) {
            this.name = name;
            this.score = score;
            this.contest = contest;
        }

        public String getContest() {
            return contest;
        }

        public void setContest(String contest) {
            this.contest = contest;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }

        String print() {
            return String.format("%s <::> %d", this.name, this.score);
        }

        String printIndividual() {
            return String.format("%s -> %d", this.name, this.score);
        }
    }
}
