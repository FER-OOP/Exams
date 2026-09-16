package hr.fer.oop.sheet;

// TODO: Finish this class
public class Sheet {

  public static final int MAX_COLUMNS = 26;

  private final int rowCount;
  private final int columnCount;
  private final double[] values;

  public Sheet(int rowCount, int columnCount) {
    // TODO: Finish me
  }

  public int getRowCount() {
    return rowCount;
  }

  public int getColumnCount() {
    return columnCount;
  }

  public double get(int row, int column) {
    // TODO: Finish me
  }

  public void set(int row, int column, double value) {
    // TODO: Finish me
  }

  public Block block(int firstRow, int firstColumn, int lastRow, int lastColumn) {
    // TODO: Finish me
  }

  public Block all() {
    return block(0, 0, rowCount - 1, columnCount - 1);
  }

}
