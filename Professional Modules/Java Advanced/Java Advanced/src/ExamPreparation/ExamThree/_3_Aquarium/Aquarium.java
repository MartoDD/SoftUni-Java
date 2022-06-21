package ExamPreparation.ExamThree._3_Aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }
    public int getFishInPool(){
        return fishInPool.size();
    }
    public void add (Fish fish){
        boolean hasFish=false;
        if (fishInPool.size()<capacity){
            for (Fish fish1 : fishInPool) {
                if (fish1.getName().equals(fish.getName())){
                    hasFish=true;
                    break;
                }
            }
            if (!hasFish){
                fishInPool.add(fish);
            }

        }
    }
    public boolean remove(String name){
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)){
                fishInPool.remove(fish);
                return true;
            }
        }
        return false;

    }
    public Fish findFish(String name){
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)){
                return fish;
            }
        }
        return null;

    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        fishInPool.forEach(f->sb.append("\n").append(f));
        return "Aquarium: " + this.name + " ^ Size: " + this.size + sb;
    }
}
