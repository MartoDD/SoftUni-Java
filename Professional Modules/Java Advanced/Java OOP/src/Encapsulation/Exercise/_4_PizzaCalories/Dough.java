package Encapsulation.Exercise._4_PizzaCalories;

public class Dough {

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (flourType.equals("White") || flourType.equals("Wholegrain")) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (bakingTechnique.equals("Chewy") || bakingTechnique.equals("Homemade") || bakingTechnique.equals("Crispy")) {
            this.bakingTechnique = bakingTechnique;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 200) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    public double calculateCalories() {
        double flourModifier=0;
        double typeModifier=0;
        switch (this.flourType) {
            case "White":
                flourModifier = 1.5;
                break;
            case "Wholegrain":
                flourModifier = 1;
                break;
        }
        switch (this.bakingTechnique) {
            case "Crispy":
                typeModifier=0.9;
                break;
            case "Chewy":
                typeModifier=1.1;
                break;
            case "Homemade":
                typeModifier=1.0;
                break;
        }
        return (weight*2)*typeModifier*flourModifier;
    }
}
