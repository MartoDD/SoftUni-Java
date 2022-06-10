package DefiningClasses.Exercises._9_CatLady;

public class Cymric extends Cat {

    private String breed;
    private String name;
    private double furLength;

    public Cymric(String breed, String name, double furLength) {
        this.breed = breed;
        this.name = name;
        this.furLength = furLength;
    }

    @Override

    public String toString(){
        return String.format("%s %s %.2f",this.breed,this.name,this.furLength);
    }
}
