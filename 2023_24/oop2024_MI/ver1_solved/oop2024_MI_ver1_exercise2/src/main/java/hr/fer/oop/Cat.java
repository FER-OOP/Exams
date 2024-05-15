package hr.fer.oop;


public final class Cat extends Animal {
	
	private String purrSound;
	
	public Cat(String id, int age, String barkSound) {
		super(id, age);
		this.purrSound = barkSound;
	}
	
	public String getPurrSound() {
		return purrSound;
	}
	
	public void setPurrSound(String purrSound) {
		this.purrSound = purrSound;
	}
	
	
}
