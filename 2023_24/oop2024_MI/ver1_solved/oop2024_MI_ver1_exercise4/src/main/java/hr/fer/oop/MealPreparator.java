package hr.fer.oop;


public class MealPreparator<A extends Nutritional, B extends Nutritional> implements Preparator<A, B, Meal> {

	@Override
	public Meal prepare(A a, B b) {
		return new Meal(a.getProtein()+b.getProtein(), a.getCarbs() + b.getCarbs(), a.getFat() + b.getFat());
	}
	
	
	

}
