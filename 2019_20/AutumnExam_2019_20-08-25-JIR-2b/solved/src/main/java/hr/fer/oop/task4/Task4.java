package hr.fer.oop.task4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task4 {

  public static void main(String[] args) {
      Map<Integer, Store> mall = Loader.loadMall();
      Store apple = mall.get(1);
      Store ronis = mall.get(2);
      System.out.println("Store items total value: " + getStoreItemsValue(apple));
      //Store items total value: 60999.95
      System.out.println("Store items with quantity higher then 10: " +
      getFilteredItemNames(ronis, 10));
      //Store items with quantity larger or equal to 10: [lg, xiaomi]
      System.out.println("Total value of items in mall: "+ mallItemsTotalValue(mall));
      //Total value of items in mall: {ps4=7200.0, xiaomi=12900.0, macBook=36000.0, lg=30000.0, iphone=39999.92}
      System.out.println("Sorted stores by number of items: "+ sortedStores(mall));
      // Sorted stores by number of items: [Ronis, Apple]
  }

  public static double getStoreItemsValue(Store store) {
      // ukupno +3
      return store.getItems().entrySet().stream(). // +1
              mapToDouble(entry -> entry.getKey().getPrice()*entry.getValue()).sum(); // +2
  }

  public static List<String> getFilteredItemNames(Store store, int minQuantity){
      // ukupno +2
      return store.getItems().entrySet().stream().filter(entry -> entry.getValue() >= minQuantity). // +1
              map(entry -> entry.getKey().getName()).collect(Collectors.toList()); // +1
  }

  public static Map<String, Double> mallItemsTotalValue(Map<Integer, Store> mall){
      Map<String, Double> itemsTotalValue = new HashMap<>();

      // ukupno +5
      mall.values().stream().flatMap(store -> store.getItems().entrySet().stream()). // +2
          forEach(entry -> itemsTotalValue.merge(entry.getKey().getName(), entry.getKey().getPrice()*entry.getValue(), (oldValue, newValue) -> oldValue + newValue)); // +3

      return itemsTotalValue;
  }

  public static List<String> sortedStores(Map<Integer, Store> mall){
      return mall.entrySet().stream().
              sorted((o1, o2) -> {
                  Integer i1 = (Integer)(o1.getValue().getItems().size());
                  Integer i2 = (Integer)(o2.getValue().getItems().size());
                  return i2.compareTo(i1);
              }).map(store -> store.getValue().getName()).
              collect(Collectors.toList());
  }
}