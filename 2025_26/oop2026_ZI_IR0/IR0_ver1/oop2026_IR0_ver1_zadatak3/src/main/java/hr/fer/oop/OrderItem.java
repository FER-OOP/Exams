package hr.fer.oop;

public class OrderItem {
    private final Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity(int amount) {
        // TODO
    }

    public double getTotalPrice() {
        // TODO
    }

    @Override
    public String toString() {
        return "OrderItem{product=" + product.getName()
                + ", quantity=" + quantity
                + ", total=" + getTotalPrice() + "}";
    }
    
}