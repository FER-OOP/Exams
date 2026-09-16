package hr.fer.oop.picture;

/**
 * The same character several times over, side by side in one row. A span of one
 * is a single character — a span is simply how a picture file writes down any
 * stretch of one character.
 */
public class Span {

  private final int row;
  private final int column;
  private final int length;
  private final char character;

  public Span(int row, int column, int length, char character) {
    this.row = row;
    this.column = column;
    this.length = length;
    this.character = character;
  }

  public int getRow() {
    return row;
  }

  public int getColumn() {
    return column;
  }

  public int getLength() {
    return length;
  }

  public char getCharacter() {
    return character;
  }

  public boolean covers(int row, int column) {
    return row == this.row && column >= this.column && column < this.column + length;
  }

}
