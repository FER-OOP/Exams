package hr.fer.oop.midterm_2020_21.task2;


public class Audio extends MultimediaItem implements Playable {

    private String artist;
    private String album;
    private final double duration;

    public Audio(String title, String artist, String album, double duration) {
        super(title);
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public void play() {

    }

    @Override
    public void pause() {

    }

    @Override
    public byte[] getIcon() {
        return null;
    }       
}
