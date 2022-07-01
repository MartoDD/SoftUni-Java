package WorkingWithAbstractions.Lab._4_HotelReservation;

public enum Discount {

    VIP(0.8),
    SECOND_VISIT(0.9),
    NONE(1);

    private double discount;

    Discount(double discount){
        this.discount=discount;
    }

    public double getDiscount() {
        return discount;
    }

    public static Discount parse(String string){
        switch (string){
            case "VIP":
                return VIP;
            case "SecondVisit":
                return SECOND_VISIT;
            case "None":
                return NONE;
            default:
                throw new IllegalArgumentException();
        }
    }
}
