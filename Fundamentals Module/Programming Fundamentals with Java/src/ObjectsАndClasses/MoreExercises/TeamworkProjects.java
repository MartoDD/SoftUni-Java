package ObjectsАndClasses.MoreExercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class TeamworkProjects {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Team> teams = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("-");
            if (teams.size() == 0) {
                Team team = new Team();
                team.setCreator(data[0]);
                team.setName(data[1]);
                team.setMembers(new ArrayList<>());
                teams.add(team);
                System.out.println("Team " + data[1] + " has been created by " + data[0] + "!");

            } else {
                AtomicBoolean isCreated = new AtomicBoolean(false);
                AtomicBoolean hasCreator = new AtomicBoolean(false);
                teams.forEach(team -> {
                    if (team.getName().equals(data[1])) {
                        System.out.println("Team " + data[1] + " was already created!");
                        isCreated.set(true);
                    }
                    if (team.getCreator().equals(data[0])) {
                        System.out.println(data[0] + " cannot create another team!");
                        hasCreator.set(true);
                    }
                });
                if (!isCreated.get() && !hasCreator.get()) {
                    Team team = new Team();
                    team.setCreator(data[0]);
                    team.setName(data[1]);
                    teams.add(team);
                    team.setMembers(new ArrayList<>());
                    System.out.println("Team " + data[1] + " has been created by " + data[0] + "!");
                }
            }

        }

        String input = scanner.nextLine();
        while (!input.equals("end of assignment")) {
            String[] data = input.split("->");
            AtomicBoolean teamExist = new AtomicBoolean(false);
            AtomicBoolean memberIsPresent = new AtomicBoolean(false);
            for (Team team1 : teams) {
                if (team1.getCreator().equals(data[0])) {
                    memberIsPresent.set(true);

                }
                team1.getMembers().forEach(s -> {
                    if (s.equals(data[0])) {
                        memberIsPresent.set(true);
                    }
                });
            }
            teams.forEach(team -> {
                if (team.getName().equals(data[1])) {
                    teamExist.set(true);
                    if (!memberIsPresent.get()) {
                        team.getMembers().add(data[0]);
                    }
                }
            });
            if (!teamExist.get()) {
                System.out.println("Team " + data[1] + " does not exist!");
            } else if (memberIsPresent.get()) {

                System.out.println("Member " + data[0] + " cannot join team " + data[1] + "!");
            }


            input = scanner.nextLine();

        }

        teams.sort(Comparator.comparing(Team::getName));
        teams.sort(Comparator.comparing(Team::numberOfMembers).reversed());
        teams.forEach(team -> {
            if (team.getMembers().size()!=0){
                System.out.println(team.getName());
                System.out.println("- " + team.creator);
                team.getMembers().stream().sorted(String::compareTo).forEach(s -> System.out.println("-- " + s));
            }
        });

        System.out.println("Teams to disband:");
        teams.forEach(team -> {
            if (team.getMembers().size() == 0) {
                System.out.println(team.getName());

            }
        });


    }

    static class Team {
        String creator;
        String name;
        List<String> members;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public List<String> getMembers() {
            return members;
        }

        public void setMembers(List<String> members) {
            this.members = members;
        }
        public int numberOfMembers(){
            return members.size();
        }
    }
}
