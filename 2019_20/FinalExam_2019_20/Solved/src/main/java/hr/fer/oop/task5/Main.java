package hr.fer.oop.task5;

import static java.lang.System.out;

public class Main {
	
	public static void main(String[] args) throws Exception {
		Vehicle v = null;
		Car c = null;
		Car c1 = null;

		try (Vehicle v1 = new Vehicle("V1", 5)) {
			v = new Vehicle("V", 12);
			c = new Car("C", -12);
			c1 = new Car("C1", -15);
		} catch (NoGasException e) {
			out.println(e.getMessage());
		} catch (Exception e) {
			out.println("Riding exception!");
		} finally {
			out.println("All vehicles created!");
			c1 = new Car("C1.1", 50);
		}

		try {
			c.ride(45);
			c1.ride(51);
			v.ride(2);
		} catch (NullPointerException e) {
			out.println("Null pointer exception");
		} catch (Exception e) {
			out.println("Exception");
		} finally {
			out.println("Rides completed!");
			((Vehicle)c1).close();			
		}
		out.println(v.remaining);		
	}

}
