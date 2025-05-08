package hr.fer.oop;

public class ParseResultCellException extends ParseResultRowException {

    private int column;

    public ParseResultCellException(int row, int column) {
        super(row);
        this.column = column;
    }

    public ParseResultCellException(int row, int column, String message) {
        super(row, message);
        this.column = column;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " and column " + column;
    }

}
