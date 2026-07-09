package hr.fer.oop;

import java.util.Set;

public class PressMember extends StadiumPerson implements AccreditedPerson {
    private final Set<StadiumArea> accreditedAreas;

    public PressMember(String name, String idCode,
                       Set<StadiumArea> accreditedAreas) {
        super(name, idCode);
        this.accreditedAreas = Set.copyOf(accreditedAreas);
    }

    @Override
    public Set<StadiumArea> getAccreditedAreas() {
        return Set.copyOf(accreditedAreas);
    }

    @Override
    public boolean hasAccreditationFor(StadiumArea area) {
        return accreditedAreas.contains(area);
    }

    @Override
    public boolean canEnter(StadiumArea area) {
        return area == StadiumArea.STANDS
                || hasAccreditationFor(area);
    }
}
