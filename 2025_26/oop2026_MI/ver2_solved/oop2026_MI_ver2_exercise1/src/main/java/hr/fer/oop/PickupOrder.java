package hr.fer.oop;

public class PickupOrder extends Order {

    public PickupOrder(String customerName, String restaurantName, double basePrice) {
        super(customerName, restaurantName, basePrice, 0);
    }

    @Override
    public boolean assignDeliveryPerson(DeliveryPerson deliveryPerson) {
        return false;
    }
    
    @Override
    public double getTotalPrice() {
        return getBasePrice();
    }

    @Override
    public int getEstimatedDeliveryTime() {
        return 0;
    }
    
    @Override
    public String getOrderInfo() {
    	 return super.getOrderInfo() + ", courier: NONE (pickup)";
    }

   
}