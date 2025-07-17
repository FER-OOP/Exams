package hr.fer.oop;

public abstract class SmartPet extends Pet {

    private int tricksLearned;

    public SmartPet(String name, int happiness, int tricksLearned) {
        super(name, happiness);
        this.tricksLearned = tricksLearned > 0 ? tricksLearned : 0;
    }

    public int getTricksLearned() {
        return tricksLearned;
    }

    @Override
    public void play() {
        super.play();

        if (tricksLearned > 0) {
            tricksLearned--;
        }
    }

    public void learnTrick() {
        tricksLearned++;
    }
}
