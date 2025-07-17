package hr.fer.oop;

public class Dog extends Pet implements SwimmerPet {
    
    public Dog(String name, int happiness) {
        super(name, happiness);
    }

    @Override
    public void swim() {
        super.happiness -= 3;
    }
    
    public void fetchBall() {
        super.happiness += 6;
    }
}
