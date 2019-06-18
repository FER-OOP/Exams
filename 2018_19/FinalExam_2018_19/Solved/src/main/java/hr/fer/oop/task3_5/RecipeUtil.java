package hr.fer.oop.task3_5;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class RecipeUtil {
	private static Random r = new Random();
	public static Map<String, String> getRecipes(String ingredient) {
		Map<String, String> map = new TreeMap<>();
		for(int i=0; i<ingredient.length(); i++) {
			map.put("Recipe #" + i, String.format("https://recipe%d/url%d", i, i));
		}
		return map;
	}
	
	public static int rating(String url) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r.nextInt(101);
	}
}
