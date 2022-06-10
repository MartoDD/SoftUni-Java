package DefiningClasses.Exercises._9_CatLady;

public class StreetExtraordinaire extends Cat {

    private String breed;
    private String name;
    private double decibelMeow;

    public StreetExtraordinaire(String name, double decibelMeow) {
        this.name = name;
        this.decibelMeow = decibelMeow;
    }

    public StreetExtraordinaire(String breed, String name, double decibelMeow) {
        this.breed = breed;
        this.name = name;
        this.decibelMeow = decibelMeow;
    }

    @Override
    public String toString(){
        return String.format("%s %s %.2f",this.breed,this.name,this.decibelMeow);
    }
}
