package hr.fer.oop.picture;

import java.nio.file.Path;

/** There is more in the file than the heading promised. */
public class ExtraDataException extends PictureException {

  private static final long serialVersionUID = 1L;

  public ExtraDataException(Path file) {
    super(file);
  }

}
