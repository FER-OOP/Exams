package red;

public class Demo {

	public static void main(String[] args) {
		Queue<String> imena = new LinkedListQueue<>();
		imena.add("Ivana").add("Janko").add("Ana").add("Branko");
		while(!imena.isEmpty()) {
			System.out.printf("prije skidanja: isEmpty=%b, size=%d%n", imena.isEmpty(), imena.size());
			System.out.println(imena.take());		
			System.out.printf("nakon skidanja: isEmpty=%b, size=%d%n", imena.isEmpty(), imena.size());
			System.out.println();
		}
	}
	
}
