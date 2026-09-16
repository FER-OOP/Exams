package hr.fer.oop.sheet;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;

/**
 * A table of numbers, like the one in a spreadsheet program (i.e. Excel). A
 * rectangular part
 * of the table is a {@link Block}, and walking a range gives its {@link Cell}s.
 * <p>
 */
public class Sheet {

  public static final int MAX_COLUMNS = 26;

  private final int rowCount;
  private final int columnCount;
  private final double[] values;

  public Sheet(int rowCount, int columnCount) {
    this.rowCount = rowCount;
    this.columnCount = columnCount;
    this.values = new double[rowCount * columnCount];
  }

  public int getRowCount() {
    return rowCount;
  }

  public int getColumnCount() {
    return columnCount;
  }

  public double get(int row, int column) {
    return values[row * columnCount + column];
  }

  public void set(int row, int column, double value) {
    values[row * columnCount + column] = value;
  }

  public Block block(int firstRow, int firstColumn, int lastRow, int lastColumn) {
    return new Block(firstRow, firstColumn, lastRow - firstRow + 1, lastColumn - firstColumn + 1);
  }

  public Block all() {
    return block(0, 0, rowCount - 1, columnCount - 1);
  }

  private static String labelOf(int row, int column) {
    return String.format("%c%d", (char) ('A' + column), row + 1);
  }

  public class Cell {

    private final int row;
    private final int column;

    Cell(int row, int column) {
      this.row = row;
      this.column = column;
    }

    public int getRow() {
      return row;
    }

    public int getColumn() {
      return column;
    }

    public double get() {
      return Sheet.this.get(row, column);
    }

    public void set(double value) {
      Sheet.this.set(row, column, value);
    }

    public String getLabel() {
      return labelOf(row, column);
    }

  }

  public class Block {

    private final int firstRow;
    private final int firstColumn;
    private final int rows;
    private final int columns;

    Block(int firstRow, int firstColumn, int rows, int columns) {
      this.firstRow = firstRow;
      this.firstColumn = firstColumn;
      this.rows = rows;
      this.columns = columns;
    }

    public int size() {
      return rows * columns;
    }

    public Iterable<Cell> rowMajor() {
      return () -> new CellWalk(i -> new Cell(firstRow + i / columns, firstColumn + i % columns));
    }

    public Iterable<Cell> columnMajor() {
      return () -> new CellWalk(i -> new Cell(firstRow + i % rows, firstColumn + i / rows));
    }

    private class CellWalk implements Iterator<Cell> {

      private final Function<Integer, Cell> cellAt;
      private int index = 0;

      CellWalk(Function<Integer, Cell> cellAt) {
        this.cellAt = cellAt;
      }

      @Override
      public boolean hasNext() {
        return index < size();
      }

      @Override
      public Cell next() {
        if (index >= size()) {
          throw new NoSuchElementException("The block has no more cells.");
        }
        return cellAt.apply(index++);
      }

    }

  }

}
