package hr.fer.oop;

public class Album extends Vinyl {
    private final int trackCount;

    public Album(String artist, String title, double price, int trackCount) {
        super(artist, title, price);
        this.trackCount = trackCount;
    }

    public int getTrackCount() {
        return trackCount;
    }

    @Override
    public String toString() {
        return "Album{" + super.toString() + ", tracks=" + trackCount + "}";
    }
}