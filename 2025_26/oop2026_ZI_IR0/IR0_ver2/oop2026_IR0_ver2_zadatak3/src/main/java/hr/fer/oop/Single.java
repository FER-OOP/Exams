package hr.fer.oop;

public class Single extends Vinyl {
    private final String bSide;

    public Single(String artist, String title, double price, String bSide) {
        super(artist, title, price);
        this.bSide = bSide;
    }

    public String getBSide() {
        return bSide;
    }

    @Override
    public String toString() {
        return "Single{" + super.toString() + ", bSide=" + bSide + "}";
    }
}