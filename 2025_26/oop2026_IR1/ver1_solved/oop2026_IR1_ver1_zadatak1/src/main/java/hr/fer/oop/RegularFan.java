package hr.fer.oop;

public class RegularFan extends StadiumPerson {
    private String seatNumber;

    public RegularFan(String name, String idCode, String seatNumber) {
        super(name, idCode);
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    @Override
    public boolean canEnter(StadiumArea area) {
        return area == StadiumArea.STANDS;
    }
}
