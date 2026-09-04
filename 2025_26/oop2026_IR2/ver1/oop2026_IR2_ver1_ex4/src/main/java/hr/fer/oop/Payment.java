package hr.fer.oop;

import java.time.LocalDate;

public class Payment {

    private final Bill bill;
    private final LocalDate dueDate;

    public Payment(Bill bill, LocalDate dueDate) {
        this.bill = bill;
        this.dueDate = dueDate;
    }

    public Bill getBill() {
        return bill;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

}