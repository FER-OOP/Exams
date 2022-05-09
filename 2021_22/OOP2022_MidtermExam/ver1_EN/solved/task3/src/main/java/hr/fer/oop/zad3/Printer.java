package hr.fer.oop.zad3;

public class Printer {

  public static String printVideoList(MyList<Video> list) {
    StringBuilder sb = new StringBuilder();
    int size = list.size();
    for (int i = 0; i < size; i++) {
      Video v = list.elementAt(i);
      sb.append(String.format("%s - %d sec. - %s\n", v.getTitle(), v.getLength(), v.getFormat()));
    }

    return sb.toString();
  }

  public static String printAudioList(MyList<? extends Audio> audios) {
    StringBuilder sb = new StringBuilder();
    int size = audios.size();

    for (int i = 0; i < size; i++) {
      Audio a = audios.elementAt(i);
      sb.append(String.format("%s - %d sec. - %s\n", a.getTitle(), a.getLength(), a.getCodec()));
    }

    return sb.toString();
  }

}

