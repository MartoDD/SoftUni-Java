package Polymorphism.Exercise._3_WildFarm;

public class Zebra extends Mammal{

    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    protected void makeSound() {
        System.out.println("Zs");
    }

    @Override
    protected void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")){
            foodEaten+=food.getQuantity();
        }else {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
    }
}
