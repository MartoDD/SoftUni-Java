package Temp;

import java.util.Iterator;
import java.util.Map;

public class Clinic implements Iterable<Integer>{

   private String name;
    private int rooms;
    private Map<Pet,Integer> pets;

    public Clinic(String name, int rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Integer next() {
                return null;
            }
        };
    }
}
