package hr.fer.oop;

public class StadiumGate {
    private String gateName;
    private StadiumArea area;

    public StadiumGate(String gateName, StadiumArea area) {
        this.gateName = gateName;
        this.area = area;
    }

    public String getGateName() {
        return gateName;
    }

    public StadiumArea getArea() {
        return area;
    }

    public String scanPerson(StadiumPerson person) {
        if (person.canEnter(area)) {
            return "Gate " + gateName + ": " + person.getName()
                    + " allowed to enter " + area;
        }

        return "Gate " + gateName + ": " + person.getName()
                + " denied access to " + area;
    }
}
