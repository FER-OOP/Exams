package hr.fer.oop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PaymentOverview implements Iterable<Payment> {

    public static final Comparator<Bill> BY_FIRST_DUE_DATE =
            Comparator.comparing(Bill::getFirstDueDate);

    public static final Function<Bill, List<Payment>> PAYMENTS_FOR_BILL =
            bill -> IntStream.range(0, bill.getInstallmentCount())
                    .mapToObj(month -> new Payment(
                            bill,
                            bill.getFirstDueDate().plusMonths(month)))
                    .collect(Collectors.toCollection(ArrayList::new));

    private List<Bill> bills;

    public PaymentOverview(List<Bill> bills) {
        this.bills = new ArrayList<>(bills);
        this.bills.sort(BY_FIRST_DUE_DATE);
    }

    @Override
    public Iterator<Payment> iterator() {
        return new PaymentIterator(bills);
    }

    private static class PaymentIterator implements Iterator<Payment> {

        private List<Bill> remainingBills;
        private List<Payment> currentPayments;

        private PaymentIterator(List<Bill> sortedBills) {
            remainingBills = new ArrayList<>(sortedBills);
            currentPayments = new ArrayList<>();
        }

        @Override
        public boolean hasNext() {
            return !remainingBills.isEmpty() || !currentPayments.isEmpty();
        }

        @Override
        public Payment next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            if (currentPayments.isEmpty()) {
                Bill bill = remainingBills.removeFirst();
                currentPayments = PAYMENTS_FOR_BILL.apply(bill);
            }

            return currentPayments.removeFirst();
        }
    }
}