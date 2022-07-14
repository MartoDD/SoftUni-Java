package Temp;

import java.util.ArrayList;
import java.util.Collection;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando{

    Collection<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
        missions=new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission) {
        missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return missions;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        missions.forEach(r->sb.append(r).append(System.lineSeparator()));
        return String.format("%s%nCorps: %s%nRepairs:%n%s",super.toString(),this.corps,sb);
    }
}
