package hr.fer.oop.task3;

public class InstagramPost<T extends Post> extends WebEntry<T>{

	public InstagramPost(String author, String date, T type) {
		super(author, date, type);
	}

	public double calculatePostImpact(int totalNumberOfLikes) {
		return this.getEntry().getNumberOfLikes()/(double) totalNumberOfLikes;
	}
}

