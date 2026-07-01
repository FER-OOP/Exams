package hr.fer.oop;

public abstract class MovableUnit extends Player {
	 
    private int fieldsMoved;
 
    public MovableUnit(String name, int defenseLevel, int fieldsMoved) {
        super(name, defenseLevel);
        this.fieldsMoved = fieldsMoved;
    }
 
    public int getFieldsMoved() {
        return fieldsMoved;
    }
 
    protected void addFields(int fields) {
        fieldsMoved += fields;
    }
 
    public abstract boolean canMove();
 
    public abstract void move(int fields);
}