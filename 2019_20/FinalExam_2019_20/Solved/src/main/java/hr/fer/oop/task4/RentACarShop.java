package hr.fer.oop.task4;

import java.util.HashSet;
import java.util.Set;

public class RentACarShop {

    private Set<RentACarTransaction> allTransactions;

    public RentACarShop() {
        this.allTransactions = new HashSet<>();
    }

    public Set<RentACarTransaction> getAllTransactions() {
        return allTransactions;
    }

    public void addTransaction(RentACarTransaction transaction) {
        this.allTransactions.add(transaction);
    }
}
