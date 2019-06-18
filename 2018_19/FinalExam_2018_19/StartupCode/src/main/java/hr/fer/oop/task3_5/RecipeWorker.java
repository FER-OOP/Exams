package hr.fer.oop.task3_5;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.swing.SwingWorker;

public class RecipeWorker extends SwingWorker<_________________> {

	private String ingredient;
	private _______________________ consumer;
	private Consumer<Integer> onDone;	
	private int avgRating;
	private ___________________________________________ formatter;
	
	public RecipeWorker(String ingredient, 
			_________________________________ consumer,
			Consumer<Integer> onDone,
			____________________________________________ formatter
	) {
		this.ingredient = ingredient;
		this.consumer = consumer;
		this.onDone = onDone;
		this.formatter = formatter;		
	}
	@Override
	protected Integer doInBackground() throws Exception {
		Map<String, String> recipes = RecipeUtil.getRecipes(ingredient);
		int sum = 0;
		int counter = 0;
		for(Map.Entry<String, String> entry : recipes.entrySet()) {			
			int rating = RecipeUtil.rating(entry.getValue());
			sum += rating;
			++counter;
			
			//TO DO: set progress and publish recipe
		}
		avgRating = sum != 0 ? sum / recipes.size() : 0;
		return avgRating;
	}
	
	//TO DO: fill the rest
}
