package hr.fer.oop.midterm_2020_21.task2;

public class Photo extends MultimediaItem {

    private final int height;
    private final int width;
    private final String dateCreated;

    public Photo(String title, int height, int width) {
        super(title);
        this.height = height;
        this.width = width;
        this.dateCreated = "TO DO: Create from current date";
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void display() {

    }

    @Override
    public byte[] getIcon() {
        return null;
    }
}
