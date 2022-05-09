package hr.fer.oop.zad3;

public class Video extends Media {
  private String videoCodec;
  private String audioCodec;
  private String format;

  public Video(String title, int length, String videoCodec, String audioCodec, String format) {
    super(title, length);
    this.videoCodec = videoCodec;
    this.audioCodec = audioCodec;
    this.format = format;
  }

  public String getVideoCodec() {
    return videoCodec;
  }

  public String getAudioCodec() {
    return audioCodec;
  }

  public String getFormat() {
    return format;
  }

}
