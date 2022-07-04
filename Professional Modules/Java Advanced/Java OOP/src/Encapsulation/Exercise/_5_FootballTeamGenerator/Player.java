package Encapsulation.Exercise._5_FootballTeamGenerator;

public class Player {

    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void setName(String name) {
        if (name!=null && !name.trim().isEmpty()){
            this.name = name;
        }else {
            throw new IllegalArgumentException("A name should not be empty.");
        }
    }

    private void setEndurance(int endurance) {
        if (checkStat(endurance)){
            this.endurance = endurance;
        }else {
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        }
    }

    private void setSprint(int sprint) {
        if (checkStat(sprint)){
            this.sprint = sprint;
        }else {
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        }
    }

    private void setDribble(int dribble) {
        if (checkStat(dribble)){
            this.dribble = dribble;
        }else {
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }
    }

    private void setPassing(int passing) {
        if (checkStat(passing)){
            this.passing = passing;
        }else {
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }
    }

    private void setShooting(int shooting) {
        if (checkStat(shooting)){
            this.shooting = shooting;
        }else {
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }
    }
    private boolean checkStat(int stat){
        return stat>=0 && stat<=100;
    }

    public String getName() {
        return name;
    }
    public double overallSkillLevel(){
        return (endurance+shooting+sprint+dribble+passing)/5.0;
    }
}
