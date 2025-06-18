package hr.fer.oop.library;

public class EBook extends DigitalResource implements Book {
    private String publisher;

    public EBook(String id, String title, String author, int publicationYear, String fileFormat, double fileSizeMB, String publisher) {
        super(id, title, author, publicationYear, fileFormat, fileSizeMB);
        this.publisher = publisher;
    }

    @Override
    public String getPublisher() {
        return publisher;
    }
}
