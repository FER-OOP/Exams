package hr.fer.oop;


public class Calculator {

	public static double score(Animal animal) {
		if (animal == null)
			return 0;

		if (animal instanceof Dog dog) {
			return (1.0d) * (dog.getAge() + dog.getBarkSound().length()) / 2;
		}

		if (animal instanceof Cat cat) {
			return (1.0d) * (cat.id.length() + cat.getPurrSound().length()) / 2;
		}

		return 0;

	}
}
