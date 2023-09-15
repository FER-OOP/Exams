package hr.fer.oop;

public class Book implements Searchable {
    private String title;
    private String author;
    protected int copiesAvailable;

    public Book(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    @Override
    public boolean search(String query) {
        // Pretraživanje knjige po naslovu ili autoru
        String lowerQuery = query.toLowerCase();
        return title.toLowerCase().contains(lowerQuery) || author.toLowerCase().contains(lowerQuery);    
    
    }
}