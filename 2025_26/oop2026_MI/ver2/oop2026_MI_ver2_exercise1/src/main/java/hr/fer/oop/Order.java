package hr.fer.oop;

import hr.fer.oop.DeliveryPerson;
import hr.fer.oop.OrderStatus;

//TODO:
//- Modify class declaration according to UML specification
//- Add required inheritance/modifiers/interfaces
//- Implement constructor and all required methods
//- Follow all functional rules described in the task text

public abstract class Order {
	private String customerName;
	private String restaurantName;
	private double basePrice;
	private double distanceKm;
	private OrderStatus status;
	private DeliveryPerson deliveryPerson;
	
	// TODO: Implement constructor according to specification
	
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
	
	 // TODO: Implement delivery person assignment logic
    public boolean assignDeliveryPerson(DeliveryPerson deliveryPerson) {
        return false;
    }

    // TODO: Implement order confirmation logic
    public boolean confirm() {
        return false;
    }

    // TODO: Implement delivery start logic
    public boolean startDelivery() {
        return false;
    }

    // TODO: Implement cancellation logic
    public boolean cancel() {
        return false;
    }

    // TODO: Implement delivery time estimation
    public int getEstimatedDeliveryTime() {
        return 0;
    }

    // TODO: Implement order description
    public String getOrderInfo() {
        return null;
    }

    // TODO: Implement total price calculation in subclasses
    public abstract double getTotalPrice();


}
