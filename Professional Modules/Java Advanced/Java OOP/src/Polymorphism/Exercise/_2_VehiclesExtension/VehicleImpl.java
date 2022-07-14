package Polymorphism.Exercise._2_VehiclesExtension;

import java.text.DecimalFormat;

public class VehicleImpl implements Vehicle{

    protected double fuelQuantity;
    protected double litersPerKm;
    protected double tankCapacity;


    public VehicleImpl(double fuelQuantity, double litersPerKm, double tankCapacity) {
        setFuelQuantity(fuelQuantity);
        this.litersPerKm = litersPerKm;
        this.tankCapacity=tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getLitersPerKm() {
        return litersPerKm;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity<0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity=fuelQuantity;
    }

    public String drive(double distance) {
        if (distance*litersPerKm>fuelQuantity){
            return getClass().getSimpleName() + " needs refueling";
        }else {
            DecimalFormat df= new DecimalFormat("#.##");
            fuelQuantity-=distance*litersPerKm;
            return getClass().getSimpleName() + " travelled "+ df.format(distance) + " km";
        }
    }

    public void refuel(double liters) {
        if (liters<=0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (fuelQuantity+liters>tankCapacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        fuelQuantity+=liters;
    }

    @Override
    public String toString(){
        return String.format("%s: %.2f",getClass().getSimpleName(),fuelQuantity);
    }
}
