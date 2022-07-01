package WorkingWithAbstractions.Lab._4_HotelReservation;

public class PriceCalculator {

    private double pricePerDay;
    private int numberOfDays;
    private SeasonMultiplayer multiplayer;
    private Discount discountType;

    public PriceCalculator(double pricePerDay, int numberOfDays, SeasonMultiplayer multiplayer, Discount discountType) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.multiplayer = multiplayer;
        this.discountType = discountType;
    }

    public double calculatePrice() {
        return pricePerDay * numberOfDays * multiplayer.getMultiplayer() * discountType.getDiscount();
    }
}
