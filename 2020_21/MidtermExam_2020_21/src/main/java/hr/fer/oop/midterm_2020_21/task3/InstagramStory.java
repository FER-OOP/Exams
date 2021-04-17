package hr.fer.oop.midterm_2020_21.task3;


public class InstagramStory extends WebEntry<Story> {

	public InstagramStory(String author, String date, Story type) {
		super(author, date, type);		
	}
	
	public double calculateStoryImpact(int totalNumberOfFollowers) {
		return (this.getEntry().getNumberOfReactions()+this.getEntry().getNumberOfViews())/(double) totalNumberOfFollowers;
	}

}
