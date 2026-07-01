package hr.fer.oop;

public class Character {
 
	private String name;
    private int health;
 
    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }
 
    public String getName() {
        return name;
    }
 
    public int getHealth() {
        return health;
    }
 
    public void increaseHealth(int amount) {
        health = Math.max(0, health + amount);
    }
 
    public void loseHealth(int amount) {
        health = Math.max(0, health - amount);
        if (health == 0) {
            System.out.println(getName() + " has been defeated!");
        }
    }
 
    @Override
    public String toString() {
        return "(" + name + ", health: " + health + ")";
    }


}
