package hr.fer.oop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class PaymentOverview {

    public static final Comparator<Bill> BY_FIRST_DUE_DATE = null; // TODO

    public static final Function<Bill, List<Payment>> PAYMENTS_FOR_BILL =
            null; // TODO

    private final List<Bill> bills;

    public PaymentOverview(List<Bill> bills) {
        this.bills = new ArrayList<>(bills);
        this.bills.sort(BY_FIRST_DUE_DATE);
    }
}