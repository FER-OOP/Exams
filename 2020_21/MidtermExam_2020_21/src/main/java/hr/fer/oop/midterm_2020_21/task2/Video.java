package hr.fer.oop.midterm_2020_21.task2;

public class Video extends MultimediaItem implements Playable {

    private final VideoType type;
    private final double duration;

    public Video(String title, VideoType type, double duration) {
        super(title);
        this.type = type;
        this.duration = duration;
    }

    public VideoType getType() {
        return type;
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
