package hr.fer.oop.library;

public class OnlineArticle extends DigitalResource {
    private String url;

    public OnlineArticle(String id, String title, String author, int publicationYear, String fileFormat, double fileSizeMB, String url) {
        super(id, title, author, publicationYear, fileFormat, fileSizeMB);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
