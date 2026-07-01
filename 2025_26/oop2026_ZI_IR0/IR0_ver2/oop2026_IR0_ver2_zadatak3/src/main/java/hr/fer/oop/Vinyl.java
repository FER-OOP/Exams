package hr.fer.oop;

public abstract class Vinyl {
    private final String artist;
    private final String title;
    private final double price;

    public Vinyl(String artist, String title, double price) {
        this.artist = artist;
        this.title = title;
        this.price = price;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "artist=" + artist + ", title=" + title + ", price=" + price;
    }
}