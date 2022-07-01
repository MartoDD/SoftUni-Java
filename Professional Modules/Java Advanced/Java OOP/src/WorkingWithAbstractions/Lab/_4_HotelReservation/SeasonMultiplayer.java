package WorkingWithAbstractions.Lab._4_HotelReservation;

public enum SeasonMultiplayer {

    AUTUMN(1),
    SPRING(2),
    WINTER(3),
    SUMMER(4);

    private int multiplayer;

    SeasonMultiplayer(int multiplayer){
        this.multiplayer=multiplayer;
    }

    public int getMultiplayer() {
        return multiplayer;
    }
    public static SeasonMultiplayer parse(String string){
        switch (string){
            case "Summer":
                return SUMMER;
            case "Autumn":
                return AUTUMN;
            case "Winter":
                return WINTER;
            case "Spring":
                return SPRING;
            default:
                throw  new IllegalArgumentException();
        }
    }
}
