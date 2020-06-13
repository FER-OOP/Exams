package hr.fer.oop.task4;

import java.util.Date;

public class Client extends Person {
    
    private final Date accountCreationDate;

    public Client(String name, String surname, double id, Date accountCreationDate) {
        super(name, surname, id);
        this.accountCreationDate = accountCreationDate;
    }

    public Date getAccountCreationDate() {
        return accountCreationDate;
    }
}
