package hr.fer.oop.library;

public class DVD extends PhysicalResource {
    private int durationInMinutes;

    public DVD(String id, String title, String author, int publicationYear, String location, int durationInMinutes) {
        super(id, title, author, publicationYear, location);
        this.durationInMinutes = durationInMinutes;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }
}
