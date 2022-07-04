package Encapsulation.Exercise._5_FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        players=new ArrayList<>();
    }

    private void setName(String name) {
        if (name!=null && !name.trim().isEmpty()){
            this.name = name;
        }else {
            throw new IllegalArgumentException("A name should not be empty.");
        }
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void removePlayer(String name){
        boolean playerRemoved=false;
        for (Player player : players) {
            if (player.getName().equals(name)){
                players.remove(player);
                playerRemoved=true;
                break;
            }
        }
        if (!playerRemoved){
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.",name,this.name));
        }

    }
    public double getRating(){
        return players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0);
    }
}
