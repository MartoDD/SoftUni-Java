package Polymorphism.Exercise._3_WildFarm;

import java.text.DecimalFormat;

public class Cat extends Feline {

    protected String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    protected void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    protected void eat(Food food) {
        foodEaten += food.getQuantity();
    }
    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]",animalName,animalType,breed,df.format(animalWeight),livingRegion,foodEaten);
    }
}
