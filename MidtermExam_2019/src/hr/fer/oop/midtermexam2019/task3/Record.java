package hr.fer.oop.midtermexam2019.task3;

public abstract class Record extends Item {

	private String artistName;
	private String albumName;
	private int duration;
	
	public Record(String artistName, String albumName, int year, int duration) {
		super(year);
		this.artistName = artistName;
		this.albumName = albumName;
		this.duration = duration;
	}
	
	public String getArtistName() {
		return artistName;
	}
	
	public String getAlbumName() {
		return albumName;
	}

	public int getDuration() {
		return duration;
	}
	
}