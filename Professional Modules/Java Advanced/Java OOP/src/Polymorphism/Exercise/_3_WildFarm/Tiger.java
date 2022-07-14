package Polymorphism.Exercise._3_WildFarm;

public class Tiger extends Feline {

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    protected void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    protected void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Meat")){
            foodEaten+=food.getQuantity();
        }else {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
    }

}
