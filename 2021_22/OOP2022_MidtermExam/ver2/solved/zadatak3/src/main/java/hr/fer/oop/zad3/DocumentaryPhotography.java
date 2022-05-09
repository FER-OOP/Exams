package hr.fer.oop.zad3;

public class DocumentaryPhotography extends Photography {
  private String theme;

  public DocumentaryPhotography(String author, String cameraModel, String theme) {
    super(author, cameraModel);
    this.theme = theme;
  }

  public String getTheme() {
    return theme;
  }

}
