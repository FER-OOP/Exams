package hr.fer.oop.zad3;

public class Painting extends Artwork implements Nameable {
  private String technique; // oil, acuarel, ...
  private String name;

  public Painting(String author, String technique, String name) {
    super(author);
    this.technique = technique;
    this.name = name;
  }

  public String getTechnique() {
    return technique;
  }

  @Override
  public String getName() {
    return name;
  }

}
