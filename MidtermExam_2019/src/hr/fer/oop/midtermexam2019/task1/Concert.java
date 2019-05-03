package hr.fer.oop.midtermexam2019.task1;

public class Concert extends Event implements EventPromoter{

	private Band playingband;
	private String[] songList;
	
	public Concert(String name, String location, String date, Band band, String[] songs) {
		super(name, location, date);
		this.playingband = band;
		this.songList = songs;
	}

	@Override
	public void printEventPoster() {
		System.out.println("Event date: " + this.getDate());
		System.out.println("Band: " + playingband.getBandName());
		System.out.println("Song list for this concert is: ");
		for(int i = 0; i < songList.length; i++) {
			System.out.println("Song " + (i + 1) + ":" + " " + songList[i]);
		}
	}
	
}
