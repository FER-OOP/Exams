package hr.fer.oop;

public abstract class DeliveryPerson {
    private String name;
    private VehicleType vehicleType;
    protected double speedKmh;

    public DeliveryPerson(String name, VehicleType vehicleType, double speedKmh) {
        this.name = name;
        this.vehicleType = vehicleType;
        this.speedKmh = speedKmh;
    }

    public String getName() {
        return name;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public double getSpeedKmh() {
        return speedKmh;
    }

    public abstract boolean canDeliverDistance(double distanceKm);

    public abstract double getDeliveryFee(double distanceKm);
}