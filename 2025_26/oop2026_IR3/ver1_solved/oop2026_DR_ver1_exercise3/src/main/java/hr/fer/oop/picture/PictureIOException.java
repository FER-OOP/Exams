package hr.fer.oop.picture;

import java.io.IOException;
import java.nio.file.Path;

/**
 * The file or the directory could not be read at all. The {@link IOException}
 * that said so is kept as the cause.
 */
public class PictureIOException extends PictureException {

  private static final long serialVersionUID = 1L;

  public PictureIOException(Path file, IOException cause) {
    super(file, cause);
  }

}
