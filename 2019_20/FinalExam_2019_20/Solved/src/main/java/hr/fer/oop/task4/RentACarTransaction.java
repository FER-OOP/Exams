package hr.fer.oop.task4;

import java.util.Date;

public class RentACarTransaction {

    private final Client client;
    private final Seller seller;
    private final Car car;
    private final Date dateOfRental;
    private final Date returnDeadline;
    private Date dateOfReturn;
    private boolean isReturned;

    public RentACarTransaction(Client client, Seller seller, Car car, Date dateOfRental, Date returnDeadline) {
        this.client = client;
        this.seller = seller;
        this.car = car;
        this.dateOfRental = dateOfRental;
        this.returnDeadline = returnDeadline;
        this.isReturned = false;
    }

    public Client getClient() {
        return client;
    }

    public Seller getSeller() {
        return seller;
    }

    public Car getCar() {
        return car;
    }

    public Date getDateOfRental() {
        return dateOfRental;
    }

    public Date getReturnDeadline() {
        return returnDeadline;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }
}
