package hr.fer.oop;

public class FoodOrder extends Order {
    private int numberOfMeals;

    public FoodOrder(String customerName, String restaurantName, double basePrice, double distanceKm, int numberOfMeals) {
        super(customerName, restaurantName, basePrice, distanceKm);
        this.numberOfMeals = numberOfMeals;
    }

    @Override
    public double getTotalPrice() {
        double deliveryFee = 0;
        if (getDeliveryPerson() != null) {
            deliveryFee = getDeliveryPerson().getDeliveryFee(getDistanceKm());
        }
        double mealSurcharge = 2 * numberOfMeals;
        return getBasePrice() + deliveryFee + mealSurcharge;
    }

    @Override
    public String getOrderInfo() {
        String courierName = (getDeliveryPerson() == null)
                ? "NONE"
                : getDeliveryPerson().getName();

        return super.getOrderInfo() +
               ", courier: " + courierName +
               ", meals: " + numberOfMeals;
    }
}