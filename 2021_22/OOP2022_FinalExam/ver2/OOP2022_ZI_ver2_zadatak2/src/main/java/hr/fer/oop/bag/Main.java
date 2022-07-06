package hr.fer.oop.bag;


public class Main {

    public static void main(String[] args) {
        Bag<Integer> bag1 = new MapBag<>();
        bag1.add(13);
        bag1.add(1);
        bag1.add(17);
        bag1.add(1);

        Bag<Integer> bag2 = new MapBag<>();//Bag<Integer> bag2 = new OtherBag<>();
        bag2.add(1);
        bag2.add(13);
        bag2.add(17);
        bag2.add(1);

        System.out.println("bag1 equals bag2: " + bag1.equals(bag2));
        System.out.println("bag2 equals bag1: " + bag2.equals(bag1));
        
        System.out.println("bag1 hashcode equals bag2 hashcode: " + (bag1.hashCode() == bag2.hashCode()));
        
        System.out.println("frequency of 1 in bag1: " + bag1.frequency(1));
        System.out.println("frequency of 17 in bag2: " + bag2.frequency(17)); 
        
        System.out.println("size of bag1: " + bag1.size());
        System.out.println("size of bag2: " + bag2.size());
        
        bag2.add(null); //throws an exception
    }
}
