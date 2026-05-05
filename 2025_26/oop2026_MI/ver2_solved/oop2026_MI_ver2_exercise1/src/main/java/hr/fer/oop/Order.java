package hr.fer.oop;

public abstract class Order implements Trackable, Cancellable {
    private String customerName;
    private String restaurantName;
    private double basePrice;
    private double distanceKm;
    private OrderStatus status;
    private DeliveryPerson deliveryPerson;

    public Order(String customerName, String restaurantName, double basePrice, double distanceKm) {
        this.customerName = customerName;
        this.restaurantName = restaurantName;
        this.basePrice = basePrice;
        this.distanceKm = distanceKm;
        this.status = OrderStatus.CREATED;
        this.deliveryPerson = null;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public DeliveryPerson getDeliveryPerson() {
        return deliveryPerson;
    }

    public boolean assignDeliveryPerson(DeliveryPerson deliveryPerson) {
    	if (deliveryPerson == null) return false;
        if (status == OrderStatus.CANCELLED) return false;
        if (this.deliveryPerson != null) return false;
        if (!deliveryPerson.canDeliverDistance(distanceKm)) return false;
       
        this.deliveryPerson = deliveryPerson;
        return true;
    }

    public boolean confirm() {
        if (status == OrderStatus.CREATED) {
            status = OrderStatus.CONFIRMED;
            return true;
        }
        return false;
    }

    public boolean startDelivery() {
        if (status == OrderStatus.CONFIRMED && deliveryPerson != null) {
            status = OrderStatus.IN_DELIVERY;
            return true;
        }
        return false;
    }

    @Override
    public boolean cancel() {
        if (status == OrderStatus.CANCELLED) {
            return false;
        }
        status = OrderStatus.CANCELLED;
        return true;
    }

    @Override
    public int getEstimatedDeliveryTime() {
        if (deliveryPerson == null) {
            return -1;
        }
        return (int) Math.ceil((distanceKm / deliveryPerson.getSpeedKmh()) * 60.0);
    }

    @Override
    public String getOrderInfo() {
        return "Order for " + customerName +
               " from " + restaurantName +
               " is " + status;
    }

    public abstract double getTotalPrice();

}