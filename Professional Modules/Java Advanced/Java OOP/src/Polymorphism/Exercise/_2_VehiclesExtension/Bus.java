package Polymorphism.Exercise._2_VehiclesExtension;

import java.text.DecimalFormat;

public class Bus extends VehicleImpl {

    public Bus(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm+1.4, tankCapacity);
    }

    public String driveEmpty(double distance){
        double temp=litersPerKm-1.4;
        if (distance*temp>fuelQuantity){
            return getClass().getSimpleName() + " needs refueling";
        }else {
            DecimalFormat df= new DecimalFormat("#.##");
            fuelQuantity-=distance*temp;
            return getClass().getSimpleName() + " travelled "+ df.format(distance) + " km";
        }
    }

}
