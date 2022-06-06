package DefiningClasses.Exercises._4_RawData;

public class Tire {

    private double tirePressure;
    private double tireAge;

    public Tire(double tirePressure, double tireAge) {
        this.tirePressure = tirePressure;
        this.tireAge = tireAge;
    }

    public double getTirePressure() {
        return tirePressure;
    }
}
