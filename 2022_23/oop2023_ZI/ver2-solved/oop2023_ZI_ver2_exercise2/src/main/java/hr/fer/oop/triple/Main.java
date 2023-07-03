package hr.fer.oop.triple;

class Main {

    public static void main(String[] args) {
        Triple triple1 = new Triple("Peter", "Peter", "Nancy");
        Triple triple2 = new Triple("Marco", "Jacob", "Peter");
        Triple triple3 = new Triple("Peter", "Jacob", "Marco");

        System.out.println("triple1 compared larger than triple2: " + (triple1.compareTo(triple2) > 0));
        System.out.println("triple2 compared equal to triple3: " + (triple2.compareTo(triple3) == 0));

        SimpleTripleTreeSet simpleTripleTreeSet = new SimpleTripleTreeSet();
        System.out.println("add triple1: " + simpleTripleTreeSet.add(triple1));
        System.out.println("add triple2: " + simpleTripleTreeSet.add(triple2));
        System.out.println("add triple3: " + simpleTripleTreeSet.add(triple3));

        simpleTripleTreeSet.forEach(triple -> System.out.printf("(%s, %s, %s);", triple.getFirst(), triple.getSecond(), triple.getThird()));
        System.out.println();

        System.out.println("simpleTripleTreeSet size: " + simpleTripleTreeSet.size());
        System.out.println("simpleTripleTreeSet contains triple2: " + simpleTripleTreeSet.contains(triple2));
        System.out.println("simpleTripleTreeSet contains triple3: " + simpleTripleTreeSet.contains(triple3));
        System.out.println("simpleTripleTreeSet remove triple3: " + simpleTripleTreeSet.remove(triple3));
        System.out.println("simpleTripleTreeSet remove triple3: " + simpleTripleTreeSet.remove(triple3));
        System.out.println("simpleTripleTreeSet size: " + simpleTripleTreeSet.size());
    }
}
