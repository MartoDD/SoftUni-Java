package ExamPreparation.ExamOne._3_EasterBasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (data.size() < capacity) {
            this.data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        for (Egg datum : data) {
            if (datum.getColor().equals(color)) {
                data.remove(datum);
                return true;
            }
        }
        return false;
    }

    public Egg getStrongestEgg() {
        Egg strongest = null;
        int strength = 0;
        for (Egg datum : data) {
            if (datum.getStrength() > strength) {
                strength=datum.getStrength();
                strongest = datum;
            }
        }
        return strongest;
    }

    public Egg getEgg(String color) {
        for (Egg datum : data) {
            if (datum.getColor().equals(color)){
                return datum;
            }
        }
        return null;
    }
    public int getCount(){
        return data.size();
    }
    public String report(){
        StringBuilder sb=new StringBuilder();
        data.forEach(egg -> sb.append("\n").append(egg.toString()));
        return this.material + " basket contains:"+  sb;
    }
}
