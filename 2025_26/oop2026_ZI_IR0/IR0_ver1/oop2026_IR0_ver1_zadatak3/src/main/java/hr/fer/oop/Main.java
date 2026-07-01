package hr.fer.oop;

import java.util.List;

public class Main {
	public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        warehouse.addProduct(new Carpet("C1", "Persian rug", 200.0, "wool", 6.0));
        warehouse.addProduct(new Carpet("C2", "Kilim", 90.0, "cotton", 4.0));
        warehouse.addProduct(new Accessory("A1", "Carpet cleaner", 15.0, true));

        Customer ivo = new Customer("Ivo", "ivo@fer.hr");
        Customer ana = new Customer("Ana", "ana@fer.hr");

        System.out.println("--- Ordering ---");
        try {
            warehouse.order(ivo, "C1", 1);
            warehouse.order(ivo, "C2", 1);
            warehouse.order(ana, "C1", 2);
            warehouse.order(ana, "A1", 3);
            warehouse.order(new Customer("Ana", "ana@fer.hr"), "C1", 1);	// Customer EXISTS -> Quantity of product C1 is now 3
            warehouse.order(ana, "X9", 1);	// ERROR
        } catch (WarehouseException e) {
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- Customers that order C1 (Persian rug) ---");
        for (Customer customer : warehouse.getCustomersWhoOrdered("C1")) {
            System.out.println(customer.getName());
        }
        
        System.out.println("\n--- Products of customer Ana ---");  
        List<OrderItem> anasProducts = warehouse.getOrders().get(ana);
        for (OrderItem orderItem : anasProducts) {
            System.out.println(orderItem.getProduct());
        }
    }
}