package hr.fer.oop;

public class Cat extends Pet {
    
    public Cat(String name, int happiness) {
        super(name, happiness);
    }
    
    public void chaseLaser()  {
        super.happiness += 4;
    }
}
