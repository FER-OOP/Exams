package hr.fer.oop;

import java.util.*;

public class Warehouse {
    private final Map<String, Product> products = new LinkedHashMap<>();
    private final Map<Customer, List<OrderItem>> orders = new LinkedHashMap<>();
    
    public void addProduct(Product p) {
        products.put(p.getId(), p);
    }

    public void order(Customer c, String productId, int quantity) throws WarehouseException {
        Product product = products.get(productId);
        if (product == null) {
            throw new WarehouseException("Product not found: " + productId);
        }

        List<OrderItem> items = orders.get(c);
        if (items == null) {
            items = new ArrayList<>();
            orders.put(c, items);
        }

        for (OrderItem item : items) {
            if (item.getProduct().equals(product)) {
                item.increaseQuantity(quantity);
                return;
            }
        }
        items.add(new OrderItem(product, quantity));
    }

	public List<Customer> getCustomersWhoOrdered(String productId) {
    	List<Customer> customers =  new ArrayList<>();
  
    	for (Map.Entry<Customer, List<OrderItem>> entry : orders.entrySet()) {
            Customer c = entry.getKey();
            for (OrderItem item : entry.getValue()) {
            	if (item.getProduct().getId().equals(productId)) {
            		customers.add(c);
            		break;
            	}
            }
        }
    	return customers;
    }
	
	public Map<String, Product> getProducts() {
		return products;
	}

	public Map<Customer, List<OrderItem>> getOrders() {
		return orders;
	}
}