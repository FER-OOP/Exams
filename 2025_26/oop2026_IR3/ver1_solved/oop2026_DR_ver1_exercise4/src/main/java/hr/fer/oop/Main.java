package hr.fer.oop;

import java.util.ArrayList;
import java.util.List;

import hr.fer.oop.sheet.Sheet;

public class Main {

  /** A sheet of 3 rows and 4 columns holding the numbers 1 to 12. */
  private static Sheet numbers() {
    Sheet sheet = new Sheet(3, 4);

    double value = 1.0;
    for (int row = 0; row < sheet.getRowCount(); row++) {
      for (int column = 0; column < sheet.getColumnCount(); column++) {
        sheet.set(row, column, value);
        value++;
      }
    }

    return sheet;
  }

  private static String number(double value) {
    return String.format("%.2f", value);
  }

  public static void main(String[] args) {
    Sheet sheet = numbers();

    // rows 1 to 2, columns 1 to 2 - both corners included
    var middle = sheet.block(1, 1, 2, 2);
    System.out.println("BLOCK SIZE: " + middle.size());

    // writing into a cell writes into the sheet the cell was taken from
    for (var cell : middle.rowMajor()) {
      cell.set(cell.get() + 100.0);
    }
    System.out.println("INSIDE:  " + number(sheet.get(1, 1)) + " " + number(sheet.get(2, 2)));
    System.out.println("OUTSIDE: " + number(sheet.get(0, 0)) + " " + number(sheet.get(1, 0)));

    // the same four cells, given out two ways
    var corner = sheet.block(0, 0, 1, 1);
    List<String> byRows = new ArrayList<>();
    for (var cell : corner.rowMajor()) {
      byRows.add(cell.getLabel());
    }
    List<String> byColumns = new ArrayList<>();
    for (var cell : corner.columnMajor()) {
      byColumns.add(cell.getLabel());
    }
    System.out.println("ROW MAJOR:    " + String.join(" ", byRows));
    System.out.println("COLUMN MAJOR: " + String.join(" ", byColumns));

    // a cell of another sheet, alive at the same time, keeps to its own numbers
    Sheet other = new Sheet(1, 1);
    other.all().rowMajor().iterator().next().set(7.0);
    System.out.println("SHEETS: " + number(sheet.get(0, 0)) + " " + number(other.get(0, 0)));
  }

}
