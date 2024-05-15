package hr.fer.oop;


public final class Dog extends Animal {
	
	protected String barkSound;
	
	public Dog(String id, int age, String barkSound) {
		super(id, age);
		this.barkSound = barkSound;
	}
	
	public String getBarkSound() {
		return barkSound;
	}
	
	public void setBarkSound(String barkSound) {
		this.barkSound = barkSound;
	}
	
	
}
