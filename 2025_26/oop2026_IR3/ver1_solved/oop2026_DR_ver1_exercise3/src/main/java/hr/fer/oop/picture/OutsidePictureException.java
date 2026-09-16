package hr.fer.oop.picture;

import java.nio.file.Path;

/**
 * An entry draws somewhere the picture does not reach — either it starts
 * outside, or it is a span that starts inside and carries on past the last
 * column of its row.
 */
public class OutsidePictureException extends PictureException {

  private static final long serialVersionUID = 1L;

  private final int row;
  private final int column;
  private final int entry;

  public OutsidePictureException(Path file, int row, int column, int entry) {
    super(file);
    this.row = row;
    this.column = column;
    this.entry = entry;
  }

  /** The row that falls outside the picture. */
  public int getRow() {
    return row;
  }

  /** The column that falls outside the picture. */
  public int getColumn() {
    return column;
  }

  /** The entry that does not fit, counted from 1. */
  public int getEntry() {
    return entry;
  }

}
