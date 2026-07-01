package hr.fer.oop;

public class Main {
    public static void main(String[] args) {
        Runner runner       = new Runner("Runner", 40);
        Stalker stalker     = new Stalker("Stalker", 50, 2);
        MainCharacter ellie = new MainCharacter("Ellie", 100);

        System.out.println("--- Initial State ---");
        System.out.println(runner);   // (Runner, health: 40)
        System.out.println(stalker);  // (Stalker, health: 50)
        System.out.println(ellie);    // (Ellie, health: 100)
        System.out.println("Stalker stealthy: " + stalker.isStealthy()); // false

        // Runner attacks Ellie — bite sets bittenTurns=1
        System.out.println("\n--- Runner attacks Ellie ---");
        runner.fight((Character) ellie);
        System.out.println(runner);                                           // health: 38
        System.out.println(ellie);                                            // health: 90
        System.out.println("Ellie bitten turns: " + ellie.getBittenTurns()); // 1

        // Ellie tries to heal — blocked, then heals
        System.out.println("\n--- Ellie tries to heal ---");
        ellie.craftMedkit(); // blocked, bittenTurns → 0
        System.out.println(ellie);                                            // health: 90
        ellie.craftMedkit(); // heals +15
        System.out.println(ellie);                                            // health: 105

        // Stalker attacks (not stealthy) → flat 10 damage, then toggleStealth → now stealthy
        System.out.println("\n--- Stalker attacks (not stealthy) ---");
        stalker.fight((Character) ellie);
        System.out.println(ellie);                                            // health: 95
        System.out.println("Stalker stealthy after attack: " + stalker.isStealthy()); // true

        // Stalker hides — stealthLevel goes from 2 to 3
        stalker.hide();
        System.out.println("Stalker stealth level: " + stalker.getStealthLevel()); // 3

        // Stalker attacks (stealthy) → 3*10=30 damage + bite sets bittenTurns=1, then toggleStealth → not stealthy
        System.out.println("\n--- Stalker attacks (stealthy) ---");
        stalker.fight((Character) ellie);
        System.out.println(ellie);                                            // health: 65
        System.out.println("Ellie bitten turns: " + ellie.getBittenTurns()); // 2
        System.out.println("Stalker stealthy after attack: " + stalker.isStealthy()); // false

        // Runner rages and attacks — enraged bite adds 2, bittenTurns: 2+2=4
        System.out.println("\n--- Runner rages and attacks ---");
        runner.rage();
        runner.fight((Character) ellie);
        System.out.println(runner);                                           // health: 34
        System.out.println(ellie);                                            // health: 45
        System.out.println("Ellie bitten turns: " + ellie.getBittenTurns()); // 4

        // Ellie fights back
        System.out.println("\n--- Ellie fights back ---");
        ellie.fight((Character) runner); // Runner -20, Ellie -2
        System.out.println(runner);      // health: 14
        System.out.println(ellie);       // health: 43

        ellie.fight((Character) stalker); // Stalker not stealthy → -10, Ellie -2
        System.out.println(stalker);      // health: 40
        System.out.println(ellie);        // health: 41
    }
}