package hr.fer.oop.library;

public abstract class PhysicalResource extends Resource {
    private String location;

    public PhysicalResource(String id, String title, String author, int publicationYear, String location) {
        super(id, title, author, publicationYear);
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
