package hr.fer.oop;

public class Customer {
    private final String name;
    private final String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // TODO: Two customers are considered equal if they have the same email address.
}