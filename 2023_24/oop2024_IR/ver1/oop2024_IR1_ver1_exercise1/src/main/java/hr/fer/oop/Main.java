package hr.fer.oop;

public class Main {

    public static void main(String[] args) {                               
        //human
        Human human = new Human("Alice", 90);
        System.out.println(human.getName() + " has " + human.getEnergy() + " energy upon creation");
        human.walk();
        System.out.println(human.getName() + " has " + human.getEnergy() + " energy after walking");
        human.work();
        System.out.println(human.getName() + " has " + human.getEnergy() + " energy after working");
        human.rest();
        System.out.println(human.getName() + " has " + human.getEnergy() + " energy after resting");

        //bee
        Bee bee = new Bee("Buzzy", 30);
        System.out.println(bee.getName() + " has " + bee.getEnergy() + " energy upon creation");
        bee.collectHoney();
        System.out.println(bee.getName() + " has " + bee.getEnergy() + " energy after collecting honey");
        FlyingCreature flyingCreature = (FlyingCreature) bee;
        flyingCreature.fly();
        System.out.println(flyingCreature.getName() + " has " + flyingCreature.getEnergy() + " energy after flying");
        flyingCreature.rest();
        System.out.println(flyingCreature.getName() + " has " + flyingCreature.getEnergy() + " energy after resting");
        
        //unicorn
        Unicorn unicorn = new Unicorn("Sparkle", 100, 50);
        System.out.println(unicorn.getName() + " has " + unicorn.getEnergy() + " energy and " + unicorn.getPower() + " power upon creation");
        unicorn.gallop();
        System.out.println(unicorn.getName() + " has " + unicorn.getEnergy() + " energy and " + unicorn.getPower() + " power after gallopig");
        MagicalCreature magicalCreature = (MagicalCreature) unicorn;
        magicalCreature.performMagic();
        System.out.println(magicalCreature.getName() + " has " + magicalCreature.getEnergy() + " energy and " + magicalCreature.getPower() + " power after performing magic");
        magicalCreature.rest();
        System.out.println(magicalCreature.getName() + " has " + magicalCreature.getEnergy() + " energy and " + magicalCreature.getPower() + " power after resting");
        
        //dragon
        Dragon dragon = new Dragon("Smaug", 150, 70);
        System.out.println(dragon.getName() + " has " + dragon.getEnergy() + " energy and " + dragon.getPower() + " power upon creation");
        flyingCreature = (FlyingCreature) dragon;
        flyingCreature.fly();
        System.out.println(flyingCreature.getName() + " has " + flyingCreature.getEnergy() + " energy and " + dragon.getPower() + " power after gallopig");
        magicalCreature = (MagicalCreature) dragon;
        magicalCreature.performMagic();
        System.out.println(magicalCreature.getName() + " has " + magicalCreature.getEnergy() + " energy and " + magicalCreature.getPower() + " power after performing magic");
        magicalCreature.rest();
        System.out.println(magicalCreature.getName() + " has " + magicalCreature.getEnergy() + " energy and " + magicalCreature.getPower() + " power after resting");
        
    }
}
