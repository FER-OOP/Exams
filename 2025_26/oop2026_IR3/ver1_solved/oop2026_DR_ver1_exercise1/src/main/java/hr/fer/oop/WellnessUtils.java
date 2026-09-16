package hr.fer.oop;

import java.util.List;

public class WellnessUtils {


    public static void turnOnAllHeatedFacilities(
            List<WellnessFacility> facilities) {

        for (WellnessFacility facility : facilities) {
            if (facility instanceof HeatedFacility heatedFacility) {
                heatedFacility.turnHeatingOn();
            }
        }
    }

}