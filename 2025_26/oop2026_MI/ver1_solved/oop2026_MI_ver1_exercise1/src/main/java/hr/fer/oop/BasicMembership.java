package hr.fer.oop;

public class BasicMembership extends Membership {

    public BasicMembership(String memberName, double price, int remainingMonths) {
        super(memberName, price, remainingMonths);
    }

    @Override
    public MembershipStatus getStatus() {
        return isActive() ? MembershipStatus.ACTIVE : MembershipStatus.EXPIRED;
    }
}