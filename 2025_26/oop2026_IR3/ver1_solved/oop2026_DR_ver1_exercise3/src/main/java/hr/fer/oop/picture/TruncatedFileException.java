package hr.fer.oop.picture;

import java.nio.file.Path;

/** The file stops before it has given everything it promised. */
public class TruncatedFileException extends PictureException {

  private static final long serialVersionUID = 1L;

  private final int entry;

  public TruncatedFileException(Path file, int entry) {
    super(file);
    this.entry = entry;
  }

  /** The entry the file stopped inside, counted from 1, or 0 for the heading. */
  public int getEntry() {
    return entry;
  }

}
