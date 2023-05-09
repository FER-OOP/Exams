package hr.fer.oop;


public interface CarManager {
	
	public int processDataset(String input);
	
	public CarDescription processLine(String line) throws ParseException;

	public double averageYear(Brand brand);
	
	public int brandCount(Brand brand) throws UnsupportedOperationException;
	

	

	
}
