package hr.fer.oop;


public class FruitSaladPreparator extends MealPreparator<Fruit, Fruit> {
	
	@Override
	public Meal prepare(Fruit a, Fruit b) {
		String name = String.format("FRUIT SALAD with %s and %s", a.getName(), b.getName());
		Meal baseMeal = super.prepare(a, b);
		
		Meal meal = new Meal(name, baseMeal.getProtein() , baseMeal.getCarbs(), baseMeal.getFat());
		
		return meal;
	}

}
