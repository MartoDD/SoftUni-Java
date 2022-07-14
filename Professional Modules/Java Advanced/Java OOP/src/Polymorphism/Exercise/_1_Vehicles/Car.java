package Polymorphism.Exercise._1_Vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle{

    public Car(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm+0.9);
    }

    @Override
    protected void drive(double distance) {
        if (distance*litersPerKm>fuelQuantity){
            System.out.println("Car needs refueling");
        }else {
            DecimalFormat df= new DecimalFormat("#.##");
            fuelQuantity-=distance*litersPerKm;
            System.out.println("Car travelled "+ df.format(distance) + " km");
        }
    }

    @Override
    protected void refuel(double liters) {
        fuelQuantity+=liters;
    }
}
