package hr.fer.oop;


public class Calculator {

	public static double score(Computer computer) {
		if (computer == null)
			return 0;

		if (computer instanceof Desktop desktop) {
			return (1.0d) * (desktop.getModel().length() + desktop.gigahertz()*1000) / 2;
		}

		if (computer instanceof Laptop laptop) {
			return (1.0d) * (laptop.getBatteryCapacity() + laptop.gigahertz()) / 2;
		}

		return 0;

	}
}
