package hr.fer.oop;

public class Dolphin extends SmartPet implements SwimmerPet {

    public Dolphin(String name, int happiness, int tricksLearned) {
        super(name, happiness, tricksLearned);
    }

    @Override
    public void swim() {
        super.happiness--;
    }

    @Override
    public void learnTrick() {
        super.learnTrick();

        super.happiness -= 4;
    }

}
