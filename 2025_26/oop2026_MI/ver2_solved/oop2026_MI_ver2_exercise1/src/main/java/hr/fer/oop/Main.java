package hr.fer.oop;

public class Main {
    public static void main(String[] args) {
    	
    	System.out.println("1) FOOD ORDER");
        System.out.println("----------------------------------------");

        Order order = new FoodOrder("Ana", "Pizza House", 18.0, 4.5, 4);
        DeliveryPerson courier = new BikeCourier("Filip");

        System.out.println("New order created.");
        System.out.println("Status: " + order.getStatus());
        System.out.println();

        System.out.println("Trying to start delivery before confirmation:");
        System.out.println("startDelivery() -> " + order.startDelivery());
        System.out.println("Status: " + order.getStatus());
        System.out.println();

        System.out.println("Confirming order:");
        System.out.println("confirm() -> " + order.confirm());
        System.out.println("Status: " + order.getStatus());
        System.out.println();
        
        System.out.println("Assigning courier:");
        System.out.println("assignDeliveryPerson(Filip) -> " + order.assignDeliveryPerson(courier));
        System.out.println("Order info: " + order.getOrderInfo());
        System.out.println("Estimated time: " + order.getEstimatedDeliveryTime() + " min");
        System.out.println();

        System.out.println("Starting delivery:");
        System.out.println("startDelivery() -> " + order.startDelivery());
        System.out.println("Status: " + order.getStatus());
        System.out.println();

        System.out.println("Final order data:");
        System.out.println("Total price: " + order.getTotalPrice());
        System.out.println("Order info: " + order.getOrderInfo());
        System.out.println();

        System.out.println("Cancelling order:");
        System.out.println("cancel() -> " + order.cancel());
        System.out.println("Status: " + order.getStatus());
        System.out.println();

        System.out.println("2) PICKUP ORDER");
        System.out.println("----------------------------------------");

        Order pickup = new PickupOrder("Sara", "Burger Bar", 12.0);

        System.out.println("New pickup order created.");
        System.out.println("Status: " + pickup.getStatus());
        System.out.println("assignDeliveryPerson(...) -> " + pickup.assignDeliveryPerson(new CarCourier("Petra")));
        System.out.println("confirm() -> " + pickup.confirm());
        System.out.println("startDelivery() -> " + pickup.startDelivery());
        System.out.println("Estimated time: " + pickup.getEstimatedDeliveryTime() + " min");
        System.out.println("Total price: " + pickup.getTotalPrice());
        System.out.println("Order info: " + pickup.getOrderInfo());
        
        
  	  // Kreiranje narudžbi
        Order o1 = new FoodOrder("Ana", "Pizza House", 18.0, 4.5, 3);
        Order o2 = new PickupOrder("Iva", "Burger Bar", 12.0);

        // Kreiranje dostavljača
        DeliveryPerson bike = new BikeCourier("Filip");
        DeliveryPerson car = new CarCourier("Petra");

        // Dodjela dostavljača
        System.out.println(o1.assignDeliveryPerson(bike)); 
        System.out.println(o2.assignDeliveryPerson(car)); 

        // Promjena statusa i pokretanje dostave
        o1.confirm();
        o1.startDelivery();

        // Praćenje narudžbe
        System.out.println(o1.getOrderInfo()); 		 
        System.out.println("Estimated time: " + o1.getEstimatedDeliveryTime()); 
        System.out.println("Total price: " + o1.getTotalPrice());  
        System.out.println(o1.getOrderInfo());   
      

        System.out.println();

        // Pickup narudžba  
        System.out.println("Estimated time: " + o2.getEstimatedDeliveryTime());  
        System.out.println("Total price: " + o2.getTotalPrice());		
        System.out.println(o2.getOrderInfo());		
    }
}