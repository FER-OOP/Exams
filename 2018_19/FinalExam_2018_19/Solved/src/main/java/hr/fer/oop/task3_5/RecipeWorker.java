package hr.fer.oop.task3_5;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.swing.SwingWorker;

public class RecipeWorker extends SwingWorker<Integer,String> {

	private String ingredient;
	private Consumer<String> consumer;
	private Consumer<Integer> onDone;	
	private int avgRating;
	private Function<Triple<String, String, Integer>, String> formatter;
	
	public RecipeWorker(String ingredient, 
			Consumer<String> consumer,
			Consumer<Integer> onDone,
			Function<Triple<String, String, Integer>, String> formatter
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
			Triple<String, String, Integer> triple = new Triple<>(entry.getKey(), entry.getValue(), rating);
			publish(formatter.apply(triple));			
			setProgress(100 * counter / recipes.size());
		}
		avgRating = sum != 0 ? sum / recipes.size() : 0;
		return avgRating;
	}
	
	@Override
	protected void process(List<String> chunks) {
		for(var chunk : chunks) {
			consumer.accept(chunk);
		}
	}
	
	@Override
	protected void done() {
		onDone.accept(avgRating);
	}		
}
