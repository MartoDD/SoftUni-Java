package ExamPreparation.ExamTwo._3_Parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot>data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
    public void add(Parrot parrot){
        if (data.size()<capacity){
            data.add(parrot);
        }
    }
    public boolean remove(String name){
        for (Parrot datum : data) {
            if (datum.getName().equals(name)){
                data.remove(datum);
                return true;
            }
        }
        return false;
    }
    public Parrot sellParrot(String name){
        for (Parrot datum : data) {
            if (datum.getName().equals(name)){
                datum.setAvailable(false);
                return datum;
            }
        }
        return null;
    }
    public List<Parrot> sellParrotBySpecies(String species){
        List<Parrot>soldParrots=new ArrayList<>();
        for (Parrot datum:data){
            if (datum.getSpecies().equals(species)){
                datum.setAvailable(false);
                soldParrots.add(datum);
            }
        }
        return soldParrots;
    }
    public int count(){
        return data.size();
    }
    public String report(){
        StringBuilder sb=new StringBuilder();
        data.stream().filter(Parrot::isAvailable).forEach(parrot -> sb.append("\n").append(parrot.toString()));
        return "Parrots available at " + this.name + ":" +sb;
    }
}
