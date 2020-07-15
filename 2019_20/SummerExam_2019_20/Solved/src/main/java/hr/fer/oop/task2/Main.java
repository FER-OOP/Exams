package hr.fer.oop.task2;

public class Main {

    public static void main(String[] args) {
        ShelterCollection<Cat> catSC1 = new ShelterCollection<>();
        catSC1.add(new Cat(1, "Korat"), new Cat(2, "Korat"), new Cat(3, "Korat"));
        catSC1.add(new Cat(4, "Ragdoll"), new Cat(5, "Ragdoll"));
        catSC1.add(new Cat(6, "Toyger"), new Cat(7, "Toyger"), new Cat(8, "Toyger"));
        for (Cat cat : catSC1) {
            System.out.print(cat.getId() + " ");
        }
        System.out.print("  ----  ");
        ShelterCollection<Cat> catSC2 = new ShelterCollection<>();
        catSC2.add(new Cat(21, "Minskin"));
        catSC2.add(new Cat(22, "Minskin"));
        catSC2.add(new Cat(23, "Peterbald"), new Cat(24, "Peterbald"));
        for (Cat cat : catSC2) {
            System.out.print(cat.getId() + " ");
        }
    }
}
