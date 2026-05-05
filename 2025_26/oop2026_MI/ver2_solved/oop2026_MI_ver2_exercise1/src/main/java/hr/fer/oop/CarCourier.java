package hr.fer.oop;

public class CarCourier extends DeliveryPerson {

    public CarCourier(String name) {
        super(name, VehicleType.CAR, 50.0);
    }

    @Override
    public boolean canDeliverDistance(double distanceKm) {
        return distanceKm >= 0;
    }

    @Override
    public double getDeliveryFee(double distanceKm) {
        return 1.8 * distanceKm + 2;
    }
}