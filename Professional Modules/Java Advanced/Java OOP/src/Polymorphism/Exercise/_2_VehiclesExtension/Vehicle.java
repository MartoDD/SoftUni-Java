package Polymorphism.Exercise._2_VehiclesExtension;

public interface Vehicle {

    double getFuelQuantity();
    double getLitersPerKm();
    void setFuelQuantity(double fuelQuantity);
    String drive(double distance);
    void refuel(double liters);

}
