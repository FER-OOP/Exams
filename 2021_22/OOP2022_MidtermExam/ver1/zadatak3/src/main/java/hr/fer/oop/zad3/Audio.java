package hr.fer.oop.zad3;

public class Audio extends Media {
  private String codec;

  public Audio(String title, int length, String codec) {
    super(title, length);
    this.codec = codec;
  }

  public String getCodec() {
    return codec;
  }

}
