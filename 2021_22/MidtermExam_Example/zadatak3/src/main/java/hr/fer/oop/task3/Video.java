package hr.fer.oop.task3;

public class Video extends Post {
	private int duration;
	private int numberOfViews = 0;

	public Video(int duration, String caption) {
		super(caption);
		this.duration = duration;
	}

	public Video(int duration, int numberOfViews, int numberOfLikes, String caption) {
		super(numberOfLikes, caption);
		this.duration = duration;
		this.numberOfViews = numberOfViews;
	}

	public int getDuration() {
		return duration;
	}

	public int getNumberOfViews() {
		return numberOfViews;
	}
	
	@Override
	public String toString() {
		return super.toString()+ "This video is "+this.getDuration()+" seconds long and has "+this.getNumberOfViews()+" views.";
	}

}
