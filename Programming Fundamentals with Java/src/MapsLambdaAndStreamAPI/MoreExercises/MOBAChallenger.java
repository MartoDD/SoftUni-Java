package MapsLambdaAndStreamAPI.MoreExercises;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class MOBAChallenger {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Map<String, Integer>> players = new LinkedHashMap<>();
        while (!input.equals("Season end")) {
            if (input.contains("->")) {                                 //in this if, we fill up the Hashmap with the players, their role and their skill
                String[] data = input.split(" -> ");
                if (players.containsKey(data[0])) {
                    if (players.get(data[0]).containsKey(data[1])) {
                        if (players.get(data[0]).get(data[1]) < Integer.parseInt(data[2])) {
                            players.get(data[0]).put(data[1], Integer.parseInt(data[2]));
                        }
                    }
                }
                players.putIfAbsent(data[0], new LinkedHashMap<>());
                players.get(data[0]).putIfAbsent(data[1], Integer.parseInt(data[2]));

            } else if (input.contains("vs")) {                           //in this if we do the comparing of the skills
                String[] data = input.split(" vs ");
                String playerOne = data[0];
                String playerTwo = data[1];
                AtomicBoolean toRemoveOne= new AtomicBoolean(false);
                AtomicBoolean toRemoveTwo= new AtomicBoolean(false);
                if (players.containsKey(playerOne) && players.containsKey(playerTwo)) {
                    players.get(playerOne).forEach((k, v) -> players.get(playerTwo).forEach((c, w) -> {
                        if (k.equals(c)) {
                            if (v > w) {
                                toRemoveTwo.set(true);
                            } else if (w > v) {
                                toRemoveOne.set(true);
                            }
                        }
                    }));
                    if (toRemoveTwo.get()){
                        players.remove(playerTwo);
                    } else if (toRemoveOne.get()) {
                    players.remove(playerOne);
                    }

                }

            }

            input = scanner.nextLine();
        }

        players.entrySet()
                .stream()
                .sorted((p1, p2) -> {
                    int result = Integer.compare(p2.getValue().values().stream().mapToInt(i -> i).sum(), p1.getValue().values().stream().mapToInt(i -> i).sum()); //first we compare the sum of the values of each key and sort it by descending
                    if (result == 0) {
                        result = p1.getKey().compareTo(p2.getKey());                                                                                              //if we happen to find two equal values, we sort by name of key (player)
                    }
                    return result;
                }).forEach(entry -> {
                    System.out.printf("%s: %d skill%n", entry.getKey(), entry.getValue().values().stream().mapToInt(i -> i).sum());           //we print the players with total skill points displayed
                    entry.getValue()
                            .entrySet()
                            .stream()
                            .sorted((e1, e2) -> {                                                                                            //we sort the individual skill values by descending order and again if we find equal values, we sort them by name of skill
                                int res = Integer.compare(e2.getValue(), e1.getValue());
                                if (res == 0) {
                                    res = e1.getKey().compareTo(e2.getKey());
                                }
                                return res;
                            }).forEach(e -> System.out.printf("- %s <::> %d%n", e.getKey(), e.getValue()));
                });
    }
}
