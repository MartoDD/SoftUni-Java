package WorkingWithAbstractions.Exercise._3_CardsWithPower;

public class Card {

    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    public int getPower(){
        return rank.getPower()+suit.getPower();
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
}
