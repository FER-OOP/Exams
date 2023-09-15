package hr.fer.oop;

public class Main {

	public static void main(String[] args) {
	
		Pair<Double, String> p1 = new Pair<Double, String>(2.5, "aaa");
		Pair<Integer, Integer> p2 = new Pair<>(2, 2);
		//Pair<String, Integer> p3 = new Pair<>("bbb", 2); compile-time error!
		
		TableEntry<String> te1 = new TableEntry<String>(1, "ccc");
		//TableEntry<String> te2 = new TableEntry<String>(1.5, "ccc"); compile-time error!

		HTable<Integer> ht1 = new HTable<>();
		ht1.add(1);
		ht1.add(2);
		ht1.add(3);
		//ht1.add(1); // exception - Element is already in HTable
		System.out.println(ht1.contains(3)); //true
		System.out.println(ht1.contains(4)); //false
		
		
		Student s1 = new Student(1, "Ana", "Anic");
		Student s2 = new Student(2, "Tin", "Maric");
		Student s3 = new Student(3, "Tomislav", "Horvat");
		Student s4 = new Student(4, "Ivana", "Grgic");
		Student s5 = new Student(5, "Ana", "Anic");
		Student s6 = new Student(6, "Ana", "Anic");
		
		HTable<Student> ht2 = new HTable<>();
		
		ht2.add(s1);
		ht2.add(s2);
		ht2.add(s3);
		ht2.add(s4);
		ht2.add(s5);
		//ht2.add(s2); //exception - Element is already in HTable
		System.out.println(ht2.contains(s2)); //true
		System.out.println(ht2.contains(s4)); //true
		System.out.println(ht2.contains(s6)); //false (s6 != s1 i s6 != s5)
		
		ht2.print();
	}

}
