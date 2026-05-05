package hr.fer.oop;

public class PremiumFamilyMembership extends FamilyMembership implements Renewable {

    private boolean autoRenew;

    public PremiumFamilyMembership(String memberName, double price, int remainingMonths, int additionalMemberCapacity, boolean autoRenew) {
        super(memberName, price, remainingMonths, additionalMemberCapacity);
        this.autoRenew = autoRenew;
    }

   
    @Override
    public boolean renew(int months) {
        if (months <= 0) {
            return false;
        }
        remainingMonths += months;
        return true;
    }

    public boolean isAutoRenew() {
        return autoRenew;
    }

    @Override
    public MembershipStatus getStatus() {
        if (isActive()) {
            if (getAdditionalMembers().length == 0) {
                return MembershipStatus.SUSPENDED;
            }
            return MembershipStatus.ACTIVE;
        } else {
            if (autoRenew) {
                return MembershipStatus.SUSPENDED;
            }
            return MembershipStatus.EXPIRED;
        }
    }
}