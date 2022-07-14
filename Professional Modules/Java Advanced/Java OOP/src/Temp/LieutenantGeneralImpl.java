package Temp;

import java.util.ArrayList;
import java.util.List;

public class LieutenantGeneralImpl extends PrivateImpl implements LeutenantGeneral{

    List<PrivateImpl> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
        privates=new ArrayList<>();
    }


    @Override
    public void addPrivate(PrivateImpl priv) {
        privates.add(priv);
    }
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        privates.forEach(p->sb.append(p).append(System.lineSeparator()));
        return String.format("%s%nPrivates:%s",super.toString(),sb);
    }
}
