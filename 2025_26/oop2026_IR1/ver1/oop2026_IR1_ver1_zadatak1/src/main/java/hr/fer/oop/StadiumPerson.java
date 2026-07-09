package hr.fer.oop;

public abstract class StadiumPerson {
    private String name;
    private String idCode;

    public StadiumPerson(String name, String idCode) {
        this.name = name;
        this.idCode = idCode;
    }

    public String getName() {
        return name;
    }

    public String getIdCode() {
        return idCode;
    }

    public abstract boolean canEnter(StadiumArea area);

    @Override
    public String toString() {
        return name + " (" + idCode + ")";
    }
}
