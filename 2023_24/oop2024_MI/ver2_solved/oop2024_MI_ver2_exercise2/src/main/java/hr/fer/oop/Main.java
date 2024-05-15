package hr.fer.oop;



public class Main {
	
	public static void main(String[] args) {
		Desktop d1 = new Desktop("BANJA-PC", 2500, "BANJA");
		Desktop d2 = new Desktop("MIRA-PC", 1800, "UNSKA 3");
		
		Laptop l1 = new Laptop("MEK", 3000, 10);
		Laptop l2 = new Laptop("HA-PE", 1000, 8);
		Laptop l3 = new Laptop("LEDOVO", 1400, 12);
		
		Computer[] computers = {d1, d2, l1, l2, l3};
		
		for(Computer computer : computers) {
			System.out.printf("Computer %s (%.2f Ghz) has a score of %.2f %n", computer.getModel(), computer.gigahertz(), Calculator.score(computer));
		}
		
	}

}
