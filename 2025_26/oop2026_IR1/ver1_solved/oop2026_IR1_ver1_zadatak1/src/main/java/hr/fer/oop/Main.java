package hr.fer.oop;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        StadiumPerson ana = new RegularFan("Ana", "F101", "A12");

        StadiumPerson clara = new PressMember(
                "Clara",
                "P303",
                Set.of(StadiumArea.PRESS_AREA, StadiumArea.STAFF_AREA)
        );

        StadiumPerson diego = new StaffMember(
                "Diego",
                "S404",
                StadiumArea.STAFF_AREA,
                true
        );

        StadiumGate standsGate =
                new StadiumGate("STANDS-1", StadiumArea.STANDS);
        StadiumGate pressGate =
                new StadiumGate("PRESS-1", StadiumArea.PRESS_AREA);
        StadiumGate staffGate =
                new StadiumGate("STAFF-1", StadiumArea.STAFF_AREA);

        System.out.println(ana);
        // Ana (F101)
        System.out.println(standsGate.scanPerson(ana));
        // Gate STANDS-1: Ana allowed to enter STANDS
        System.out.println(pressGate.scanPerson(ana));
        // Gate PRESS-1: Ana denied access to PRESS_AREA

        System.out.println();

        System.out.println(clara);
        // Clara (P303)
        AccreditedPerson pressAccreditation = (AccreditedPerson) clara;
        System.out.println(pressAccreditation.getAccreditedAreas().size());
        // 2
        System.out.println(
                pressAccreditation.hasAccreditationFor(StadiumArea.PRESS_AREA));
        // true
        System.out.println(pressGate.scanPerson(clara));
        // Gate PRESS-1: Clara allowed to enter PRESS_AREA
        System.out.println(staffGate.scanPerson(clara));
        // Gate STAFF-1: Clara allowed to enter STAFF_AREA

        System.out.println();

        StaffMember staff = (StaffMember) diego;
        AccreditedPerson staffAccreditation = staff;

        System.out.println(diego);
        // Diego (S404)
        System.out.println(staffAccreditation.getAccreditedAreas().size());
        // 1
        System.out.println(
                staffAccreditation.hasAccreditationFor(StadiumArea.STAFF_AREA));
        // true
        System.out.println(staffGate.scanPerson(diego));
        // Gate STAFF-1: Diego allowed to enter STAFF_AREA

        staff.setOnDuty(false);

        System.out.println(staff.isOnDuty());
        // false
        System.out.println(staffGate.scanPerson(diego));
        // Gate STAFF-1: Diego denied access to STAFF_AREA
        System.out.println(standsGate.scanPerson(diego));
        // Gate STANDS-1: Diego denied access to STANDS
    }
}
