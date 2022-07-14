package Polymorphism.Exercise._2_VehiclesExtension;

public class Car extends VehicleImpl {


    public Car(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm+0.9, tankCapacity);
    }


}
