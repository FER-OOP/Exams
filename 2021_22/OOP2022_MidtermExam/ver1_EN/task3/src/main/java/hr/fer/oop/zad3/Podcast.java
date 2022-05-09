package hr.fer.oop.zad3;

public class Podcast extends Audio {
  private String guest;

  public Podcast(String title, int length, String codec, String guest) {
    super(title, length, codec);
    this.guest = guest;
  }

  public String getGuest() {
    return guest;
  }

}
