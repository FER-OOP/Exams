package hr.fer.oop;

import java.util.List;

public class Main {

    public static void main(String[] args) {
    	

        // RelaxationRoom - already implemented


        RelaxationRoom room = new RelaxationRoom("Quiet Room");

        System.out.println(room.getName() + ": uses = " + room.getNumberOfUses());

        room.use();

        System.out.println(room.getName() + ": uses = " + room.getNumberOfUses() + " after using the facility.");

      

        /*
         * Uncomment the following code after implementing OutdoorPool.
         *

        OutdoorPool pool = new OutdoorPool("Outdoor Pool", 24.5, 40);

        System.out.println(pool.getName() + ": temperature = " + pool.getWaterTemperature() + ", capacity = " + pool.getCapacity() + ", uses = " + pool.getNumberOfUses());

        pool.use();

        System.out.println(pool.getName() + ": uses = " + pool.getNumberOfUses());
        
        */

        /*
         * Uncomment the following code after implementing HotTub.
         *

        HotTub hotTub = new HotTub("Jacuzzi", 34.0, 6);

        System.out.println(hotTub.getName() + ": temperature = " + hotTub.getWaterTemperature() + ", capacity = " + hotTub.getCapacity() + ", heating = " + hotTub.isHeatingOn() + ", uses = " + hotTub.getNumberOfUses());

        hotTub.use();

        System.out.println(hotTub.getName() + ": uses = " + hotTub.getNumberOfUses() + " after using the facility.");

        hotTub.heatWater(3.0);

        System.out.println(hotTub.getName() + ": temperature = " + hotTub.getWaterTemperature() + " while heating is off.");

        hotTub.turnHeatingOn();
        hotTub.heatWater(3.0);

        System.out.println(hotTub.getName() + ": heating = " + hotTub.isHeatingOn() + ", temperature = " + hotTub.getWaterTemperature());

        */

        /*
         * Uncomment the following code after implementing Sauna.
         *

        Sauna sauna = new Sauna("Finnish Sauna");

        System.out.println(sauna.getName() + ": heating = " + sauna.isHeatingOn() + ", uses = " + sauna.getNumberOfUses());

        sauna.use();

        System.out.println(sauna.getName() + ": uses = " + sauna.getNumberOfUses() + " while heating is off.");

        sauna.turnHeatingOn();
        sauna.use();

        System.out.println(sauna.getName() + ": heating = " + sauna.isHeatingOn() + ", uses = " + sauna.getNumberOfUses());

        */

        /*
         * Uncomment the following code after implementing WellnessUtils.
         *

        List<WellnessFacility> facilities = List.of(pool, hotTub, sauna, room);
        
        hotTub.turnHeatingOff();
        sauna.turnHeatingOff();

        WellnessUtils.turnOnAllHeatedFacilities(facilities);

        System.out.println("After turnOnAllHeatedFacilities:");

        System.out.println(hotTub.getName() + ": heating = " + hotTub.isHeatingOn());

        System.out.println(sauna.getName() + ": heating = " + sauna.isHeatingOn());

        */

    }
}