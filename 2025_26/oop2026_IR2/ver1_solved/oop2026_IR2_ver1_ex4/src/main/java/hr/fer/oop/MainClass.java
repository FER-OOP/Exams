package hr.fer.oop;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class MainClass {

    public static void main(String[] args) {
        List<Bill> bills = List.of(
                new Bill("Internet bill", 30.0, 2,
                        LocalDate.of(2026, 12, 5)),
                new Bill("Water bill", 15.0, 1,
                        LocalDate.of(2027, 1, 20)),
                new Bill("Electricity bill", 40.0, 3,
                        LocalDate.of(2026, 11, 10)));

        PaymentOverview overview = new PaymentOverview(bills);

        System.out.println("Payment overview:");
        for (Payment payment : overview) {
            Bill bill = payment.getBill();

            System.out.printf(
                    Locale.US,
                    "%s | %.2f EUR | due %s%n",
                    bill.getDescription(),
                    bill.getInstallmentAmount(),
                    payment.getDueDate());
        }

    }
}