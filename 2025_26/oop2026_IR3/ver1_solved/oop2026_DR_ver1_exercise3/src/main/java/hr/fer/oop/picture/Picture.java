package hr.fer.oop.picture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A picture of characters, `width` columns wide and `height` rows tall. Given
 * class — do not modify.
 *
 * <p>
 * The picture keeps <b>no grid of cells at all</b>. It keeps only the spans it
 * was given, in the order they were given, exactly as the file holds them.
 * <p>
 * Rows and columns are counted from 0, position (0, 0) is top left (row 0 and
 * column 0).
 */
public class Picture {

  private final int width;
  private final int height;
  private final char blank;
  private final List<Span> entries = new ArrayList<>();

  public Picture(int width, int height, char blank) {
    this.width = width;
    this.height = height;
    this.blank = blank;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public char getBlank() {
    return blank;
  }

  public boolean holds(int row, int column) {
    return row >= 0 && row < height && column >= 0 && column < width;
  }

  public void add(Span entry) {
    entries.add(entry);
  }

  public List<Span> getEntries() {
    return Collections.unmodifiableList(entries);
  }

  public char get(int row, int column) {
    char character = blank;
    for (Span entry : entries) {
      if (entry.covers(row, column)) {
        character = entry.getCharacter();
      }
    }
    return character;
  }

  @Override
  public String toString() {
    StringBuilder text = new StringBuilder();
    for (int row = 0; row < height; row++) {
      if (row > 0) {
        text.append(System.lineSeparator());
      }
      for (int column = 0; column < width; column++) {
        text.append(get(row, column));
      }
    }
    return text.toString();
  }

}
