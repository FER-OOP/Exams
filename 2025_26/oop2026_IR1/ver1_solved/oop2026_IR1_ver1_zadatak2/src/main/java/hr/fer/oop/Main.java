package hr.fer.oop;

public class Main {
    public static void main(String[] args) {
        GameRoom<RacingMachine> racingRoom =
                new GameRoom<>("Racing room");
        GameRoom<RhythmMachine> rhythmRoom =
                new GameRoom<>("Rhythm room");

        try {
            racingRoom.addMachine(
                    new RacingMachine("R-001", "Turbo Drift", 3, 220));
            racingRoom.addMachine(
                    new RacingMachine("R-002", "Night Racers", 4, 260));
            rhythmRoom.addMachine(
                    new RhythmMachine("M-001", "Beat Master", 2, 40));
            rhythmRoom.addMachine(
                    new RhythmMachine("M-002", "Dance Floor", 1, 25));
        } catch (DuplicateException e) {
            System.out.println("A duplicate machine was detected.");
            // A duplicate machine was detected.
        }

        Arcade arcade = new Arcade();

        try {
            arcade.addRoom(racingRoom);
            arcade.addRoom(rhythmRoom);
        } catch (DuplicateException e) {
            System.out.println("A duplicate room was detected.");
            // A duplicate room was detected.
        }

        System.out.println(racingRoom);
        // Racing room (2 machine(s))

        System.out.println(rhythmRoom);
        // Rhythm room (2 machine(s))

        System.out.println("Total machines: "
                + arcade.getTotalMachineCount());
        // Total machines: 4

        System.out.println("\nRacing machines:");
        // Racing machines:

        for (RacingMachine machine : racingRoom.getMachines()) {
            System.out.println(machine);
            // [R-001] Turbo Drift (Racing) - 3 token(s)
            // [R-002] Night Racers (Racing) - 4 token(s)
        }

        System.out.println(
                "\nRhythm machines requiring at most 2 tokens:");
        // Rhythm machines requiring at most 2 tokens:

        for (RhythmMachine machine
                : rhythmRoom.getMachinesRequiringAtMost(2)) {
            System.out.println(machine);
            // [M-001] Beat Master (Rhythm) - 2 token(s)
            // [M-002] Dance Floor (Rhythm) - 1 token(s)
        }

        System.out.println("\nFound machine: "
                + arcade.findMachine("M-001"));
        // Found machine: [M-001] Beat Master (Rhythm) - 2 token(s)

        System.out.println("Missing machine: "
                + arcade.findMachine("X-404"));
        // Missing machine: null

        System.out.println("Missing room: "
                + arcade.findRoom("Unknown room"));
        // Missing room: null

        try {
            racingRoom.addMachine(
                    new RacingMachine("R-001", "Speed Challenge", 2, 200));
        } catch (DuplicateException e) {
            System.out.println("Duplicate machine detected.");
            // Duplicate machine detected.
        }

        try {
            arcade.addRoom(
                    new GameRoom<RacingMachine>("Racing room"));
        } catch (DuplicateException e) {
            System.out.println("Duplicate room detected.");
            // Duplicate room detected.
        }

        try {
            racingRoom.getMachines().add(
                    new RacingMachine("R-003", "Road King", 2, 180));
        } catch (UnsupportedOperationException e) {
            System.out.println(
                    "The returned machine list is unmodifiable.");
            // The returned machine list is unmodifiable.
        }
    }
}
