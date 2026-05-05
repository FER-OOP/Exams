package hr.fer.oop;

public abstract class Membership {

    private String memberName;
    private double price;
    protected int remainingMonths;

    public Membership(String memberName, double price, int remainingMonths) {
        this.memberName = memberName;
        this.price = price;
        this.remainingMonths = remainingMonths;
    }


    public String getMemberName() {
        return memberName;
    }


    public double getPrice() {
        return price;
    }

    public int getRemainingMonths() {
        return remainingMonths;
    }
    
    protected boolean isActive() {
        return remainingMonths > 0;
    }
    
    public abstract MembershipStatus getStatus();
}