package hr.fer.oop;


public class BikeCourier extends DeliveryPerson {

    public BikeCourier(String name) {
        super(name, VehicleType.BICYCLE, 15.0);
    }

    @Override
    public boolean canDeliverDistance(double distanceKm) {
        return distanceKm >= 0 && distanceKm <= 5;
    }

    @Override
    public double getDeliveryFee(double distanceKm) {
        return 0.8 * distanceKm;
    }
}