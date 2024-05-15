package hr.fer.oop;


public interface DisabilityDatasetManager {
	
	public int processDataset(String input);
	
	public DisabilityRecord processLine(String line) throws DisabilityException;

	public String maxRating(Disability disability);
	
	public String share(Disability disability) throws UnsupportedOperationException;

}
