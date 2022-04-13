package hr.fer.oop.task3;

public class Story {

	private int numberOfViews;
	private int numberOfReactions;

	public Story(int numberOfViews, int numberOfReactions) {
		this.numberOfViews = numberOfViews;
		this.numberOfReactions = numberOfReactions;
	}

	public int getNumberOfViews() {
		return numberOfViews;
	}

	public int getNumberOfReactions() {
		return numberOfReactions;
	}

}
