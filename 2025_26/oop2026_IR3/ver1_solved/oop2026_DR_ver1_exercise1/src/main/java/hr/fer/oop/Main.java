package hr.fer.oop;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        OutdoorPool pool = new OutdoorPool("Outdoor Pool", 24.5, 40);
        HotTub hotTub = new HotTub("Jacuzzi", 34.0, 6);
        Sauna sauna = new Sauna("Finnish Sauna");
        RelaxationRoom room = new RelaxationRoom("Quiet Room");

        System.out.println("INITIAL STATE");

        System.out.println(pool.getName()
                + ": temperature = " + pool.getWaterTemperature()
                + ", capacity = " + pool.getCapacity()
                + ", uses = " + pool.getNumberOfUses());

        System.out.println(hotTub.getName()
                + ": temperature = " + hotTub.getWaterTemperature()
                + ", capacity = " + hotTub.getCapacity()
                + ", heating = " + hotTub.isHeatingOn()
                + ", uses = " + hotTub.getNumberOfUses());

        System.out.println(sauna.getName()
                + ": heating = " + sauna.isHeatingOn()
                + ", uses = " + sauna.getNumberOfUses());

        System.out.println(room.getName()
                + ": uses = " + room.getNumberOfUses());


        System.out.println("\nUSING FACILITIES");

        pool.use();
        hotTub.use();
        sauna.use();
        room.use();

        System.out.println(pool.getName()
                + ": uses = " + pool.getNumberOfUses());

        System.out.println(hotTub.getName()
                + ": uses = " + hotTub.getNumberOfUses());

        System.out.println(sauna.getName()
                + ": uses = " + sauna.getNumberOfUses());

        System.out.println(room.getName()
                + ": uses = " + room.getNumberOfUses());


        System.out.println("\nHEATING");

        hotTub.heatWater(3.0);

        System.out.println(hotTub.getName()
                + ": temperature = " + hotTub.getWaterTemperature());

        hotTub.turnHeatingOn();
        sauna.turnHeatingOn();

        hotTub.heatWater(3.0);
        sauna.use();

        System.out.println(hotTub.getName()
                + ": heating = " + hotTub.isHeatingOn()
                + ", temperature = " + hotTub.getWaterTemperature());

        System.out.println(sauna.getName()
                + ": heating = " + sauna.isHeatingOn()
                + ", uses = " + sauna.getNumberOfUses());


        System.out.println("\nCOLLECTIONS");

        List<WellnessFacility> facilities = List.of(pool, hotTub, sauna, room);

        hotTub.turnHeatingOff();
        sauna.turnHeatingOff();

        WellnessUtils.turnOnAllHeatedFacilities(facilities);

        System.out.println("After turnOnAllHeatedFacilities:");

        System.out.println(hotTub.getName()
                + ": heating = " + hotTub.isHeatingOn());

        System.out.println(sauna.getName()
                + ": heating = " + sauna.isHeatingOn());

        
    }
}