package hr.fer.oop.library;

public abstract class DigitalResource extends Resource {
    private String fileFormat;
    private double fileSizeMB;

    public DigitalResource(String id, String title, String author, int publicationYear, String fileFormat, double fileSizeMB) {
        super(id, title, author, publicationYear);
        this.fileFormat = fileFormat;
        this.fileSizeMB = fileSizeMB;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public double getFileSizeMB() {
        return fileSizeMB;
    }
}
