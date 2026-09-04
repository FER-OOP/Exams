package hr.fer.oop;

import java.time.LocalDate;

public class Bill {

    private final String description;
    private final double installmentAmount;
    private final int installmentCount;
    private final LocalDate firstDueDate;

    public Bill(String description, double installmentAmount,
            int installmentCount, LocalDate firstDueDate) {
        this.description = description;
        this.installmentAmount = installmentAmount;
        this.installmentCount = installmentCount;
        this.firstDueDate = firstDueDate;
    }

    public String getDescription() {
        return description;
    }

    public double getInstallmentAmount() {
        return installmentAmount;
    }

    public int getInstallmentCount() {
        return installmentCount;
    }

    public LocalDate getFirstDueDate() {
        return firstDueDate;
    }
}