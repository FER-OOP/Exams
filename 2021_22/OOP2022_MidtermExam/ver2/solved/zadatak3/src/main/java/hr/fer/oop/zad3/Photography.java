package hr.fer.oop.zad3;

public class Photography extends Artwork {
  private String cameraModel;

  public Photography(String author, String cameraModel) {
    super(author);
    this.cameraModel = cameraModel;
  }

  public String getCameraModel() {
    return cameraModel;
  }

}
