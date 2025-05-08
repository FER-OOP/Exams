package hr.fer.oop;

public class Main {

  public static void main(String[] args) {
    Floor floor0 = new Floor("Ground", "level 0");
    floor0.addSpace(new Classroom("PClab 1", 60.0, 30));
    floor0.addSpace(new Toilet("Toilet 1", 10.0, ToiletType.MALE));
    floor0.addSpace(new Toilet("Toilet 2", 20.0, ToiletType.FEMALE));

    Floor floor1 = new Floor("First floor", "level 1");
    floor1.addSpace(new ClassroomWithWater("PClab 2", 60.0, 30));
    floor1.addSpace(new Toilet("Toi†let 3", 25, ToiletType.UNISEX));

    System.out.println(floor0);
    for(Space space : floor0.getSpaces()) {
      System.out.println(" " + space);
    }
    System.out.println("---");
    System.out.println(floor1);
    for(Space space : floor1.getSpaces()) {
      System.out.println(" " + space);
    }

    System.out.println("---");
    Floor floor2 = new Floor("Second floor", "level 2");
    System.out.println("Adding floor: " + floor2.addSpace(floor0));
    for(int i = 0; i < 12; i++) {
      Classroom lab = new Classroom("PClab " + (i + 1), 10.0, 5);
        System.out.println(floor2.addSpace(lab));
      }
    }

}
