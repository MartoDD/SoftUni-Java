package Polymorphism.Exercise._1_Vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle{

    public Truck(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm+1.6);
    }

    @Override
    protected void drive(double distance) {
        if (distance*litersPerKm>fuelQuantity){
            System.out.println("Truck needs refueling");
        }else {
            DecimalFormat df= new DecimalFormat("#.##");
            fuelQuantity-=distance*litersPerKm;
            System.out.println("Truck travelled "+ df.format(distance) + " km");
        }
    }

    @Override
    protected void refuel(double liters) {
    fuelQuantity+=liters*0.95;
    }
}
