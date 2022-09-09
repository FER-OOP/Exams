package hr.fer.oop.t2.loaders;

public interface DataLoader {
	public Iterable<String> Load() throws NoDataException;
}
