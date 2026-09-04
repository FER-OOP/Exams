package hr.fer.oop;

public class RowFormatException extends CatchLogException {

    public RowFormatException(int row) {
        super(row, "Invalid row format at row " + row);
    }
}
