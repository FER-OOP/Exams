package hr.fer.oop;

public class DVD extends Content<Integer> {
    public DVD(String id, String title, Integer duration) {
        super(id, title, duration);
    }

    @Override
    public String describeContent() {
        return "Duration: " + getData() + " minutes";
    }
}