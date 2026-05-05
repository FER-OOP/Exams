package hr.fer.oop;

public class FamilyMembership extends Membership {

    private String[] additionalMembers;
    private int memberCount;

    public FamilyMembership(String memberName, double price, int remainingMonths, int additionalMemberCapacity) {
        super(memberName, price, remainingMonths);
        this.additionalMembers = new String[additionalMemberCapacity];
        this.memberCount = 0;
    }

    public boolean addMember(String name) {
        if (!isActive()) {
            return false;
        }

        if (name == null || name.trim().isEmpty()) {
            return false;
        }

        if (memberCount >= additionalMembers.length) {
            return false;
        }

        additionalMembers[memberCount++] = name;
        return true;
    }

    
    public int countMembers() {
        return 1 + getAdditionalMembers().length;
    }


    protected String[] getAdditionalMembers() {
        String[] copy = new String[memberCount ];
        for (int i = 0; i < memberCount ; i++) {
            copy[i] = additionalMembers[i];
        }
        return copy;
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 10 * memberCount ;
    }

    @Override
    public MembershipStatus getStatus() {
        if (!isActive()) {
            return MembershipStatus.EXPIRED;
        }
        if (memberCount  == 0) {
            return MembershipStatus.SUSPENDED;
        }
        return MembershipStatus.ACTIVE;
    }
}