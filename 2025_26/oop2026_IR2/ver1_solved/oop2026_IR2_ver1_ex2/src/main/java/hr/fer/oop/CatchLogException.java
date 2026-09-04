package hr.fer.oop;

public class CatchLogException extends Exception {

    private final int row;

    public CatchLogException(int row) {
        super();
        this.row = row;
    }

    public CatchLogException(int row, String message) {
        super(message);
        this.row = row;
    }

    public int getRow() {
        return row;
    }
}
