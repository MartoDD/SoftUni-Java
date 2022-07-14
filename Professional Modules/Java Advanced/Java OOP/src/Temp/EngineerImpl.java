package Temp;

import java.util.ArrayList;
import java.util.Collection;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer{

    Collection<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
        repairs=new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepair() {
        return repairs;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        repairs.forEach(r->sb.append(r).append(System.lineSeparator()));
        return String.format("%s%nCorps: %s%nRepairs:%n%s",super.toString(),this.corps,sb);
    }
}
