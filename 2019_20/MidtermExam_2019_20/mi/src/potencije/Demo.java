package potencije;

public class Demo {

	public static void main(String[] args) {
Potencije od2 = new Potencije(2, 5);

System.out.println("Ispisujem ih:");
for(Integer p : od2) {
	System.out.println(p);
	if(p > 4) break;
}

System.out.println("Još jednom ih ispisujem:");
for(Integer p : od2) {
	System.out.println(p);
}
	}
}
