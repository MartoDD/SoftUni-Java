package Encapsulation.Exercise._4_PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);
    }

    private void setName(String name) {
        if (name!=null && (!name.trim().isEmpty())){
            this.name = name;
        }else {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int numberOfToppings) {
        if (numberOfToppings>=0 && numberOfToppings<=10){
            this.toppings = new ArrayList<>();
        }else {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    public String getName() {
        return name;
    }
    public void addTopping(Topping topping){
        toppings.add(topping);
    }
    public double getOverallCalories(){
        double toppingsCalories=toppings.stream().mapToDouble(Topping::calculateCalories).sum();
        double doughCalories=this.dough.calculateCalories();
        return toppingsCalories + doughCalories;
    }
}
