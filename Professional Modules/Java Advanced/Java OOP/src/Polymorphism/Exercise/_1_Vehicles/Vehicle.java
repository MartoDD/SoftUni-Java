package Polymorphism.Exercise._1_Vehicles;

public abstract class Vehicle {

    protected double fuelQuantity;
    protected double litersPerKm;

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getLitersPerKm() {
        return litersPerKm;
    }

    public Vehicle(double fuelQuantity, double litersPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.litersPerKm = litersPerKm;
    }

    protected abstract void drive(double distance);
    protected abstract void refuel(double liters);

}
