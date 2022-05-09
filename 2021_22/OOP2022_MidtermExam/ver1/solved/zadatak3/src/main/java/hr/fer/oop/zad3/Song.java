package hr.fer.oop.zad3;

public class Song extends Audio {
  private String author;

  public Song(String title, int length, String codec, String author) {
    super(title, length, codec);
    this.author = author;
  }

  public String getAuthor() {
    return author;
  }

}
