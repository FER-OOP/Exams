package hr.fer.oop;

public class Parrot extends SmartPet {
    
    public Parrot(String name, int happiness, int tricksLearned) {
        super(name, happiness, tricksLearned);
    }
    
    public void sing() {
        super.happiness += 4;
    }

    @Override
    public void learnTrick() {
        super.learnTrick();
        
        super.happiness -= 2;
    }
    
    
}
