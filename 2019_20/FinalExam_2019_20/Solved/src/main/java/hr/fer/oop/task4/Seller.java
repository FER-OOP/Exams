package hr.fer.oop.task4;

import java.util.Date;

public class Seller extends Person {

    private final Date employmentDate;

    public Seller(String name, String surname, double id, Date employmentDate) {
        super(name, surname, id);
        this.employmentDate = employmentDate;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }      
}
