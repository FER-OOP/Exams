package hr.fer.oop;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Mittens", 50);
        System.out.println(cat.getName() + " has " + cat.getHappiness() + " happiness upon creation");
        cat.chaseLaser();
        System.out.println(cat.getName() + " has " + cat.getHappiness() + " happiness after chasing laser");
        cat.play();
        System.out.println(cat.getName() + " has " + cat.getHappiness() + " happiness after playing\n");

        SwimmerPet dog = new Dog("Buddy", 60);
        System.out.println(dog.getName() + " has " + dog.getHappiness() + " happiness upon creation");
        ((Dog) dog).fetchBall();
        System.out.println(dog.getName() + " has " + dog.getHappiness() + " happiness after fetching ball");
        dog.swim();
        System.out.println(dog.getName() + " has " + dog.getHappiness() + " happiness after swimming");
        dog.play();
        System.out.println(dog.getName() + " has " + dog.getHappiness() + " happiness after playing\n");

        SmartPet parrot = new Parrot("Polly", 70, 0);
        System.out.println(parrot.getName() + " has " + parrot.getHappiness() + " happiness and " + parrot.getTricksLearned() + " tricks upon creation");
        parrot.learnTrick();
        System.out.println(parrot.getName() + " has " + parrot.getHappiness() + " happiness and " + parrot.getTricksLearned() + " tricks after learning trick");
        ((Parrot) parrot).sing();
        System.out.println(parrot.getName() + " has " + parrot.getHappiness() + " happiness after singing");
        parrot.play();
        System.out.println(parrot.getName() + " has " + parrot.getHappiness() + " happiness and " + parrot.getTricksLearned() + " tricks after playing\n");

        Dolphin dolphin = new Dolphin("Flippy", 80, 2);
        System.out.println(dolphin.getName() + " has " + dolphin.getHappiness() + " happiness and " + dolphin.getTricksLearned() + " tricks upon creation");
        dolphin.swim();
        System.out.println(dolphin.getName() + " has " + dolphin.getHappiness() + " happiness after swimming");
        dolphin.learnTrick();
        System.out.println(dolphin.getName() + " has " + dolphin.getHappiness() + " happiness and " + dolphin.getTricksLearned() + " tricks after learning trick");
        dolphin.play();
        System.out.println(dolphin.getName() + " has " + dolphin.getHappiness() + " happiness and " + dolphin.getTricksLearned() + " tricks after playing");
    }
}
