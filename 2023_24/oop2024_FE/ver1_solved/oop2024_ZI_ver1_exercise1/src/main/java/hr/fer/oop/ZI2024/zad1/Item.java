package hr.fer.oop.ZI2024.zad1;

public class Item {
	private String name;
	private int quantity;
    private double price;
    
    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    
	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
        return this.price;
    }
	
    public double getTotalPrice() {
        return this.price * this.quantity;
    }
    
	@Override
	public String toString() {
		return "Item [name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}
}
