package hr.fer.oop.library;

public class PhysicalBook extends PhysicalResource implements Book {
    private int pageCount;
    private String edition;
    private String publisher;

    public PhysicalBook(String id, String title, String author, int publicationYear, String location, int pageCount, String edition, String publisher) {
        super(id, title, author, publicationYear, location);
        this.pageCount = pageCount;
        this.edition = edition;
        this.publisher = publisher;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getEdition() {
        return edition;
    }

    @Override
    public String getPublisher() {
        return publisher;
    }
}
