package Inheritance.Exercise._4_NeedForSpeed;

public class Car extends Vehicle{

    public Car(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(3);
    }
}
