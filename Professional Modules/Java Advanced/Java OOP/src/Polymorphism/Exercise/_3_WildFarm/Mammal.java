package Polymorphism.Exercise._3_WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    protected String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]",animalName,animalType,df.format(animalWeight),livingRegion,foodEaten);
    }
}
