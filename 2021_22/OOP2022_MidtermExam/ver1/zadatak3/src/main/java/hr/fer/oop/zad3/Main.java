package hr.fer.oop.zad3;

public class Main {
  public static void main(String[] args) {
    Video video1 = new Video("Dune", 9300, "H265", "MP3", "3840 x 2160");
    Video video2 = new Video("Don't Look Up", 8280, "H264", "AAC", "1920 x 1080");
    Podcast podcast1 = new Podcast("Inside Java", 1800, "MP3", "none");
    Podcast podcast2 = new Podcast("Coding 101", 1200, "AAC", "none");
    Song song1 = new Song("Free software Song", 122, "MP3", "Richard Stallman");
    Song song2 = new Song("Java Life (Code Hard)", 192, "AAC", "Dev Crew");
    Song song3 = new Song("I Hate the DMCA", 203, "AAC", "Joe Wecker");

    MediaPrinter<Media> mediaPrinter = new MediaPrinter<>();
    mediaPrinter.addLast(video1);
    mediaPrinter.addLast(podcast1);
    mediaPrinter.addLast(song1);
    System.out.println(mediaPrinter.print());

    MyList<Video> videos = new MyList<>();
    videos.addLast(video1);
    videos.addLast(video2);
    System.out.println(Printer.printVideoList(videos));

    MyList<Audio> audios = new MyList<>();
    audios.addLast(podcast1);
    audios.addLast(podcast2);
    audios.addLast(song1);
    System.out.println(Printer.printAudioList(audios));

    MyList<Song> songs = new MyList<>();
    songs.addLast(song1);
    songs.addLast(song2);
    songs.addLast(song3);
    System.out.println(Printer.printAudioList(songs));

    MediaPrinter<Video> videoPrinter = new MediaPrinter<>(); // OK
    
    //Printer.printVideoList(songs); // greška kod prevođenja
    //Printer.printVideoList(mediaPrinter); // greška kod prevođenja

    //Printer.printAudioList(mediaPrinter); // greška kod prevođenja
    //Printer.printAudioList(videos); // greška kod prevođenja
    Printer.printAudioList(new MyList<Podcast>()); // OK
  }

}
