package hr.fer.oop;


public class Main {
	
	public static void main(String[] args) {
		Dog dog1 = new Dog("Cathy", 4, "vau-vau-vau-vau");
		Dog dog2 = new Dog("Mary", 8, "VAU-VAUUU");
		
		Cat cat1 = new Cat("Kimi", 2, "mijau-mijau");
		Cat cat2 = new Cat("Niki", 3, "mijauu");
		Cat cat3 = new Cat("Mika", 1, "mijauuuuuuuuuuu");
		
		Animal[] animals = {dog1, dog2, cat1, cat2, cat3};
		
		for(Animal animal : animals) {
			System.out.printf("Animal %s has an animal score of %d and calculator score of %.2f %n", animal.getId(), animal.score(), Calculator.score(animal));
		}
		
	
	}

}
