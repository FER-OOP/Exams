package hr.fer.oop;


public abstract class Animal {
	public final String id;
	
	int age;
	
	public Animal(String id, int age) {
		this.id = id;
		this.age = age;
	}
		
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}	
	
	public final int score() {
		return id.length() + age;
	}
	
	public String getId() {
		return id;
	}

}
