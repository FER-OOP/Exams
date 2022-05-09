package hr.fer.oop.zad3;

public class ArtPhotography extends Photography implements Nameable {
  private String type; // portrait, landscape, ...
  private String name;

  public ArtPhotography(String author, String cameraModel, String type, String name) {
    super(author, cameraModel);
    this.type = type;
    this.name = name;
  }

  public String getType() {
    return type;
  }

  @Override
  public String getName() {
    return name;
  }

}
