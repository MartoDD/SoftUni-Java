package ExamPreparation.ExamSix._3_GroomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {

    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data=new ArrayList<>();
    }

    public void add(Pet pet){
        if (data.size()<capacity){
            data.add(pet);
        }
    }
    public boolean remove(String name){
        for (Pet pet : data) {
            if (pet.getName().equals(name)){
                data.remove(pet);
                return true;
            }
        }
        return false;
    }
    public Pet getPet(String name,String owner){
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)){
                return pet;
            }
        }
        return null;
    }
    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        data.forEach(p-> sb.append("\n").append(p.getName()).append(" ").append(p.getOwner()));
        return "The grooming salon has the following clients:" + sb;
    }
}
