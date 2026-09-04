package hr.fer.oop;

public class Main {
    public static void main(String[] args) {

        // =========================
        // 1) SAILING BOAT
        // =========================
        System.out.println("1) SAILING BOAT");
        System.out.println("---------------");

        SailingBoat boat = new SailingBoat("Adriana", "ST-101", 8.5, 60.0, 2);
        System.out.println("Can sail: " + boat.canSail());
        System.out.println("Status: " + boat.getStatus());
        System.out.println();

        // =========================
        // 2) FISHING TRAWLER
        // =========================
        System.out.println("2) FISHING TRAWLER");
        System.out.println("-------------------");

        FishingTrawler trawler = new FishingTrawler("Neptun", "FT-207", 14.0, 80.0, 500.0);
        System.out.println("Adding 200kg: " + trawler.addCatch(200.0));
        System.out.println("Adding 250kg: " + trawler.addCatch(250.0));
        System.out.println("Status: " + trawler.getStatus());
        System.out.println("Can sail: " + trawler.canSail());
        System.out.println();

        // =========================
        // 3) RESEARCH VESSEL
        // =========================
        System.out.println("3) RESEARCH VESSEL");
        System.out.println("-------------------");

        ResearchVessel vessel = new ResearchVessel("Argus", "RV-303", 22.0, 90.0, false);
        System.out.println("Status before calibration: " + vessel.getStatus());
        vessel.startCalibration();
        System.out.println("Status during calibration: " + vessel.getStatus());
        System.out.println("Can sail during calibration: " + vessel.canSail());
        System.out.println();

        // =========================
        // 4) INDUSTRIAL TRAWLER
        // =========================
        System.out.println("4) INDUSTRIAL TRAWLER");
        System.out.println("----------------------");

        IndustrialTrawler small = new IndustrialTrawler("Titan", "IT-501", 20.0, 70.0, 1000.0, 2);
        System.out.println("Can sail (crewSize=2): " + small.canSail());
        System.out.println("Status (crewSize=2): " + small.getStatus());

        IndustrialTrawler full = new IndustrialTrawler("Titan", "IT-501", 20.0, 70.0, 1000.0, 5);
        System.out.println("Can sail (crewSize=5): " + full.canSail());
        System.out.println("Status before big catch: " + full.getStatus());
        full.addCatch(950.0);
        System.out.println("Status after 950kg catch: " + full.getStatus());
    }
}
