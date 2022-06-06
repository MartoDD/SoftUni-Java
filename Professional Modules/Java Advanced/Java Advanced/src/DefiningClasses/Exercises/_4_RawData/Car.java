package DefiningClasses.Exercises._4_RawData;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private String model;
    private Cargo cargo;
    private Engine engine;
    private List<Tire> tires;

    public Car(String model, Cargo cargo, Engine engine, List<Tire> tires) {
        this.model = model;
        this.cargo = cargo;
        this.engine = engine;
        this.tires=new ArrayList<>(tires);
    }

    public String getModel() {
        return model;
    }

    public List<Tire> getTires() {
        return tires;
    }

    public boolean checkStatus(String input) {
        switch (input) {
            case "fragile":
                return cargo.getCargoType().equals("fragile") && checkTires(this.tires);
            case "flamable":
                return cargo.getCargoType().equals("flamable") && engine.getEnginePower() >= 250;
        }
        return false;

    }

    private boolean checkTires(List<Tire> tires) {
        for (Tire tire : tires) {
            if (tire.getTirePressure()<1){
                return true;
            }
        }
        return false;

    }
}
