package hr.fer.oop.pair;

class Main {

    public static void main(String[] args){
        Pair<String, Double> pair1 = new Pair<>("Peter", 2.7);
        Pair<Integer, String> pair2 = new Pair<>(7, "Marco");
        Pair<Double, String> pair3 = new Pair<>(2.7, "Peter");

        System.out.println("pair1 equals pair2: " + pair1.equals(pair2));
        System.out.println("pair1 equals pair3: " + pair1.equals(pair3));

        System.out.println("pair1 hashcode equals pair2 hashcode: " + (pair1.hashCode() == pair2.hashCode()));
        System.out.println("pair1 hashcode equals pair3 hashcode: " + (pair1.hashCode() == pair3.hashCode()));

        SimplePairHashSet simplePairHashSet = new SimplePairHashSet();
        System.out.println("add pair1: " + simplePairHashSet.add(pair1));
        System.out.println("add pair2: " + simplePairHashSet.add(pair2));
        System.out.println("add pair3: " + simplePairHashSet.add(pair3));

        simplePairHashSet.forEach(pair -> System.out.printf("(%s, %s);", pair.getFirst(), pair.getSecond()));
        System.out.println();

        System.out.println("simplePairHashSet size: " + simplePairHashSet.size());
        System.out.println("simplePairHashSet contains pair1: " + simplePairHashSet.contains(pair1));
        System.out.println("simplePairHashSet contains pair3: " + simplePairHashSet.contains(pair3));
        System.out.println("simplePairHashSet remove pair3: " + simplePairHashSet.remove(pair3));
        System.out.println("simplePairHashSet remove pair3: " + simplePairHashSet.remove(pair3));
        System.out.println("simplePairHashSet size: " + simplePairHashSet.size());
    }
}
