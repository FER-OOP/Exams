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

    public static final Comparator<MusicRecord> BY_DURATION =
            Comparator.comparingInt(MusicRecord::getDurationSeconds);

    public static final Comparator<MusicRecord> BY_LISTENS =
            Comparator.comparingInt(MusicRecord::getListenCount);

    public static final Comparator<MusicRecord> BY_GENRE =
            Comparator.comparing(MusicRecord::getGenre);

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MusicRecord)) return false;
        MusicRecord other = (MusicRecord) o;
        return Objects.equals(songName, other.songName) &&
               Objects.equals(artistName, other.artistName);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(songName, artistName);
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
