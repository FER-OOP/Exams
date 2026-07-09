package hr.fer.oop;

import java.util.Set;

public class StaffMember extends StadiumPerson implements AccreditedPerson {
    private StadiumArea assignedArea;
    private boolean onDuty;

    public StaffMember(String name, String idCode,
                       StadiumArea assignedArea, boolean onDuty) {
        super(name, idCode);
        this.assignedArea = assignedArea;
        this.onDuty = onDuty;
    }

    public StadiumArea getAssignedArea() {
        return assignedArea;
    }

    public boolean isOnDuty() {
        return onDuty;
    }

    public void setOnDuty(boolean onDuty) {
        this.onDuty = onDuty;
    }

    @Override
    public Set<StadiumArea> getAccreditedAreas() {
        return Set.of(assignedArea);
    }

    @Override
    public boolean hasAccreditationFor(StadiumArea area) {
        return area == assignedArea;
    }

    @Override
    public boolean canEnter(StadiumArea area) {
        return onDuty
                && (area == StadiumArea.STANDS
                || hasAccreditationFor(area));
    }
}
