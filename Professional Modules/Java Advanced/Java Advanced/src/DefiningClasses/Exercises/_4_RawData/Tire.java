package DefiningClasses.Exercises._4_RawData;

public class Tire {

    private double tireAge;
    private double tirePressure;

    public Tire(double tireAge, double tirePressure) {
        this.tireAge = tireAge;
        this.tirePressure = tirePressure;
    }

    public double getTirePressure() {
        return tirePressure;
    }
}
