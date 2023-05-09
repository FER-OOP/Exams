package hr.fer.oop;

import java.util.Arrays;

public class Documentary extends Movie {
	private boolean forProfit;
	public Documentary(String title, Director director, Rating rating, boolean forProfit) {
        super(title, director, new Person[]{}, rating);
        this.forProfit = forProfit;
    }

	@Override
    public String toString() {
        return String.format("Documentary '%s' by %s rated %s (for profit: %b)", title, author(), rating, forProfit);
        	
    }
    
    public boolean isForProfit() {
		return forProfit;
	}

}
