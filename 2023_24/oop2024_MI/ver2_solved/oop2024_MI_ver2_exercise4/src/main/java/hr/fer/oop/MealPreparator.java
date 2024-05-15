package hr.fer.oop;


public class MealPreparator<B extends Nutritional> implements Preparator<Fruit, B, Meal> {

	@Override
	public Meal prepare(Fruit a, B b) {
		return new Meal(a.getProtein()+b.getProtein(), a.getCarbs() + b.getCarbs(), a.getFat() + b.getFat());
	}
	
	
	

}
