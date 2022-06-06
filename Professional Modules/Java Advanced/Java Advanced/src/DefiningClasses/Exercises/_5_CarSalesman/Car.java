package DefiningClasses.Exercises._5_CarSalesman;

public class Car {

    private String model;
    private Engine engine;
    private int weight; //
    private String color; //


    public Car(String model) {
        this.model = model;

    }

    public Car(String model, int weight) {
        this(model);
        this.weight = weight;
    }

    public Car(String model, String color) {
        this(model);
        this.color = color;
    }

    public Car(String model, int weight, String color) {
        this(model);
        this.weight = weight;
        this.color = color;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return this.model + ":\n"
                + this.engine.getModel() + ":\n"
                + "Power: " + this.engine.getPower() + "\n"
                + "Displacement: " + (this.engine.getDisplacement() == 0 ? "n/a" : this.engine.getDisplacement()) + "\n"
                + "Efficiency: " + (String.valueOf(this.engine.getEfficiency()).equals("null") ? "n/a" : this.engine.getEfficiency()) + "\n"
                + "Weight: " + (this.weight == 0 ? "n/a" : this.weight) + "\n"
                + "Color: " + (String.valueOf(this.color).equals("null") ? "n/a" : this.color);
    }
}

