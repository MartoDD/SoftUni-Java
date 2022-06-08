package DefiningClasses.Exercises._7_Google;

public class Car {
    private String model;
    private int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public String print(){
        return this.model + " " + this.speed;
    }
}
