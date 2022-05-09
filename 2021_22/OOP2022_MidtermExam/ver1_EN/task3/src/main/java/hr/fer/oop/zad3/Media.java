package hr.fer.oop.zad3;

public class Media {
  private String title;
  private int length; // in seconds

  public Media(String title, int length) {
    this.title = title;
    this.length = length;
  }

  public String getTitle() {
    return title;
  }

  public int getLength() {
    return length;
  }

}
