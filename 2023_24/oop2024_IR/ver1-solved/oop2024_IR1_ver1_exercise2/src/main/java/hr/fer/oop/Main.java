package hr.fer.oop;

public class Main {
    public static void main(String[] args) {
        SpecialCollection<Item> itemCollection = new SpecialLinkedList<>();

        Item item1 = new Item("Sword", 300, "Weapon");
        Item item2 = new Item("Shield", 150, "Armor");
        Item item3 = new Item("Potion", 50, "Consumable");
        Item item4 = new Item("Helmet", 100, "Armor");
        Item item5 = new Item("Sword", 300, "Weapon"); // Duplicate
        Item item6 = null; // Null-value

        itemCollection.add(item1);
        itemCollection.add(item2);
        itemCollection.add(item3);
        itemCollection.add(item4);
        //itemCollection.add(item5); // Should throw an IllegalArgumentException
        //itemCollection.add(item6); // Should throw an NullPointerException

        System.out.println("\nAll items:");
        System.out.println(itemCollection);        

        System.out.println("\nRemoving item 'Shield':");
        itemCollection.remove(item2);
        System.out.println(itemCollection);
        
        System.out.println("\nAll items sorted:");
        System.out.println(itemCollection.getSorted());           
    }
}
