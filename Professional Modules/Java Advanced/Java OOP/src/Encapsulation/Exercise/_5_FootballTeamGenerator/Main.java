package Encapsulation.Exercise._5_FootballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Team> teams = new LinkedHashMap<>();

        while (!input.equals("END")) {
            try {


                String[] commands = input.split(";");
                String command = commands[0];
                String teamName = commands[1];
                String playerName;
                switch (command) {
                    case "Add":
                        if (!teams.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            playerName = commands[2];
                            int stat1 = Integer.parseInt(commands[3]);
                            int stat2 = Integer.parseInt(commands[4]);
                            int stat3 = Integer.parseInt(commands[5]);
                            int stat4 = Integer.parseInt(commands[6]);
                            int stat5 = Integer.parseInt(commands[7]);
                            Player player = new Player(playerName, stat1, stat2, stat3, stat4, stat5);
                            teams.get(teamName).addPlayer(player);
                        }
                        break;
                    case "Remove":
                        playerName = commands[2];
                        teams.get(teamName).removePlayer(playerName);
                        break;
                    case "Team":
                        Team team = new Team(teamName);
                        teams.put(teamName, team);

                        break;
                    case "Rating":
                        if (!teams.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            System.out.println(teamName + " - " + Math.round(teams.get(teamName).getRating()));
                        }
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            input = scanner.nextLine();
        }


    }
}
