package Polymorphism.Exercise._2_VehiclesExtension;

public class Truck extends VehicleImpl {


    public Truck(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm+1.6, tankCapacity);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters*0.95);
    }
}
