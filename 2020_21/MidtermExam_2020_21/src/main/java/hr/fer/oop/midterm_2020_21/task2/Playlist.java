package hr.fer.oop.midterm_2020_21.task2;

public class Playlist extends MultimediaItem implements Playable {

    private Playable[] playables;

    public Playlist(String title, int maxSize, Playable... playables) {
        super(title);
        this.playables = new Playable[maxSize];
        for(int i=0; i<playables.length; i++) {
        	this.playables[i] = playables[i];
        }
    }

    public void add(Playable item) {

    }


    public void remove(Playable item) {

    }

    @Override
    public void play() {

    }

    @Override
    public void pause() {

    }

    public void next() {

    }

    public void previous() {

    }

    @Override
    public byte[] getIcon() {
        return null;
    }
}
