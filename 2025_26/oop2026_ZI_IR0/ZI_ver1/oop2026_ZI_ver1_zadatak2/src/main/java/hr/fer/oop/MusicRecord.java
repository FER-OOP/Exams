package hr.fer.oop;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public class MusicRecord {

    private String songName;
    private String artistName;
    private String genre;
    private int durationSeconds;
    private int listenCount;
    private LocalDate lastPlayed;

    public static final Comparator<MusicRecord> BY_DURATION = null; //TODO

    public static final Comparator<MusicRecord> BY_LISTENS = null; //TODO

    public static final Comparator<MusicRecord> BY_GENRE = null; //TODO

    public MusicRecord(String songName, String artistName, String genre, int durationSeconds, int listenCount, LocalDate lastPlayed) {
        this.songName = songName;
        this.artistName = artistName;
        this.genre = genre;
        this.durationSeconds = durationSeconds;
        this.listenCount = listenCount;
        this.lastPlayed = lastPlayed;
    }

    public String getSongName() {
        return songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getGenre() {
        return genre;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public int getListenCount() {
        return listenCount;
    }

    public LocalDate getLastPlayed() {
        return lastPlayed;
    }
 
    @Override
    public String toString() {
        return "(" +
                songName + ", " +
                artistName + ", " +
                genre + ", " +
                durationSeconds + ", " +
                listenCount + ", " +
                lastPlayed +
                ")";
    }

}
