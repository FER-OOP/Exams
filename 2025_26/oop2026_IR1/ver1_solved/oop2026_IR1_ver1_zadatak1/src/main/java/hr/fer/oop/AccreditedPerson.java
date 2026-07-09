package hr.fer.oop;

import java.util.Set;

public interface AccreditedPerson {
    Set<StadiumArea> getAccreditedAreas();

    boolean hasAccreditationFor(StadiumArea area);
}
