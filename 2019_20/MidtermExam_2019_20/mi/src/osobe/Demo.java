package osobe;

public class Demo {

	public static void main(String[] args) {
		Osoba[] osobe = new Osoba[] {
				new Student("Janko", "FER"),
				new Zaposlenik("Kristina", "ACME"),
				new Direktor("Jasna", "ACME", 10000.0)
		};
		
		int[] duljine = new int[osobe.length];
		for(int i = 0; i < osobe.length; i++) {
			duljine[i] = osobe[i].getIme().length();
		}

		for(Osoba o : osobe) {
			System.out.println(o.getIme());
			if(o instanceof Zaposlenik) {
				Zaposlenik z = (Zaposlenik)o;
				System.out.println(" Zaposlenje u tvrtki "+z.getTvrtka());
			}
		}

		Osoba janko = new Student("Janko", "FER");
		for(Osoba o : osobe) {
			System.out.println(o==janko);
		}
		
		System.out.println("X");
		
		System.out.println(osobe[0].getIme()+" "+duljine[0]+" "+janko.getIme());
	}
}
