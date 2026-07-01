package hr.fer.oop;

public class GameObject {
	
	private String name;
    private int defenseLevel;
 
    public GameObject(String name, int defenseLevel) {
        this.name = name;
        this.defenseLevel = defenseLevel;
    }
 
    public String getName() {
        return name;
    }
 
    public int getDefenseLevel() {
        return defenseLevel;
    }
    
    public void increaseDefenseLevel(int amount) {
        this.defenseLevel = Math.max(0, defenseLevel + amount);
    }
 
    public void weaken(int amount) {
        this.defenseLevel = Math.max(0, defenseLevel - amount);
    }

}
