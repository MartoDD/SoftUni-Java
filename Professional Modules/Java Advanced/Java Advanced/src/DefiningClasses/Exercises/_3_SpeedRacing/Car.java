package DefiningClasses.Exercises._3_SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCost;
    private int distanceTravelled;

    public Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distanceTravelled = 0;
    }

    public void Drive(int distance) {

        if (distance * fuelCost <= fuelAmount) {
            distanceTravelled += distance;
            fuelAmount -= distance * fuelCost;
        } else {
            Car.printMessage();
        }

    }

    public static void printMessage() {
        System.out.println("Insufficient fuel for the drive");
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTravelled);
    }


}
