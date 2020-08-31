package hr.fer.oop.task4;

import java.util.LinkedHashMap;
import java.util.Map;

public class Loader {
  public static Map<Integer, Store> loadMall() {
    Map<Integer, Store> mallMap = new LinkedHashMap<>();
    Item tv = new Item("lg", 2500);
    Item iphone = new Item("iphone", 4999.99);
    Item mac = new Item("macBook", 12000);
    Item scooter = new Item("xiaomi", 1290);
    Item ps = new Item("ps4", 900);

    Store apple = new Store("Apple");
    Store ronis = new Store("Ronis");

    apple.addItem(iphone, 5);
    apple.addItem(mac, 3);

    ronis.addItem(tv, 12);
    ronis.addItem(ps, 8);
    ronis.addItem(scooter, 10);
    ronis.addItem(iphone, 3);

    mallMap.put(1, apple);
    mallMap.put(2, ronis);

    return mallMap;
  }
}