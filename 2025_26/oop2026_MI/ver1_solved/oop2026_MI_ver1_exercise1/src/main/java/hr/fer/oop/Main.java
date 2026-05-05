package hr.fer.oop;

public class Main {
    public static void main(String[] args) {

        // =========================
        // 1) BASIC MEMBERSHIP
        // =========================
        System.out.println("1) BASIC MEMBERSHIP");
        System.out.println("-------------------");

        BasicMembership basic = new BasicMembership("Ana", 25.0, 3);

        System.out.println("Member: " + basic.getMemberName());
        System.out.println("Price: " + basic.getPrice());
        System.out.println("Remaining months: " + basic.getRemainingMonths());
        System.out.println("Status: " + basic.getStatus());
        System.out.println();


        // =========================
        // 2) FAMILY MEMBERSHIP
        // =========================
        System.out.println("2) FAMILY MEMBERSHIP");
        System.out.println("--------------------");

        FamilyMembership family = new FamilyMembership("Ivana", 40.0, 5, 3);

        System.out.println("Main member: " + family.getMemberName());
        System.out.println("Initial price: " + family.getPrice());
        System.out.println("Remaining months: " + family.getRemainingMonths());
        System.out.println("Status before adding members: " + family.getStatus());

        // --- Adding members ---
        System.out.println("\n--- ADDING MEMBERS ---");
        System.out.println("Adding member Luka: " + family.addMember("Luka"));
        System.out.println("Adding member Mia: " + family.addMember("Mia"));
        System.out.println("Adding member Ema: " + family.addMember("Ema"));
        System.out.println("Adding member with empty name: " + family.addMember(""));
        System.out.println("Adding member Ivan (capacity exceeded): " + family.addMember("Ivan"));

        System.out.println("Total members: " + family.countMembers());
        System.out.println("Price after adding members: " + family.getPrice());
        System.out.println("Status after adding members: " + family.getStatus());
        System.out.println();


     // =========================
     // 3) PREMIUM FAMILY MEMBERSHIP
     // =========================
     System.out.println("3) PREMIUM FAMILY MEMBERSHIP");
     System.out.println("----------------------------");

     PremiumFamilyMembership premium = new PremiumFamilyMembership("Petar", 50.0, 0, 5, true);

     System.out.println("Main member: " + premium.getMemberName());
     System.out.println("Initial price: " + premium.getPrice());
     System.out.println("Remaining months: " + premium.getRemainingMonths());
     System.out.println("Auto-renew enabled: " + premium.isAutoRenew());

     System.out.println("\n--- BEFORE RENEWAL ---");
     System.out.println("Status: " + premium.getStatus());

     // Attempt to add members while membership is NOT active
     System.out.println("\n--- ADDING MEMBERS (NOT ACTIVE) ---");
     System.out.println("Adding member Sara: " + premium.addMember("Sara"));
     System.out.println("Adding member Nika: " + premium.addMember("Nika"));
     System.out.println("Total members: " + premium.countMembers());

     //Activate membership 
     System.out.println("\n--- RENEWAL ---");
     System.out.println("Renewal for 12 months: " + premium.renew(12));
     System.out.println("Remaining months after renewal: " + premium.getRemainingMonths());

    
     System.out.println("\n--- ADDING MEMBERS (AFTER RENEWAL) ---");
     System.out.println("Adding member Sara: " + premium.addMember("Sara"));
     System.out.println("Adding member Nika: " + premium.addMember("Nika"));

     System.out.println("Total members: " + premium.countMembers());
     System.out.println("Price after adding members: " + premium.getPrice());

     System.out.println("\n--- FINAL STATUS ---");
     System.out.println("Status: " + premium.getStatus());
     System.out.println();
    }
}