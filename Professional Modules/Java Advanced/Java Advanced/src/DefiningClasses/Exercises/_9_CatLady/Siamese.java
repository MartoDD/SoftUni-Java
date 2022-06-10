package DefiningClasses.Exercises._9_CatLady;

public class Siamese extends Cat {

    private String breed;
    private String name;
    private double earSize;

    public Siamese(String breed, String name, double earSize) {
        this.breed = breed;
        this.name = name;
        this.earSize = earSize;
    }

    @Override
    public String toString(){
        return String.format("%s %s %.2f",this.breed,this.name,this.earSize);
    }
}
