package hr.fer.oop.picture;

import java.nio.file.Path;

/**
 * Something went wrong while reading a picture out of a file. This is the
 * exception all the others are, and it is never thrown itself: it holds only
 * what every one of them has, which is the file the trouble was in.
 */
public abstract class PictureException extends Exception {

  private static final long serialVersionUID = 1L;

  private final Path file;

  protected PictureException(Path file) {
    this.file = file;
  }

  protected PictureException(Path file, Throwable cause) {
    super(cause);
    this.file = file;
  }

  /** The file this came from. */
  public Path getFile() {
    return file;
  }

}
