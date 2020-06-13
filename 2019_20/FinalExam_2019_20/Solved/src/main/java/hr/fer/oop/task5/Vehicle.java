package hr.fer.oop.task5;

import java.io.Closeable;
import java.io.IOException;
import static java.lang.System.out;

public class Vehicle implements Closeable {

	int remaining;
	String id;

	public Vehicle(String id, int remainingMileage) throws NoGasException {
		this.id = id;
		out.println(id);
		if (remainingMileage < 0) {
			throw new NoGasException("Remaining mileage must be above 0;");
		} else {
			this.remaining = remainingMileage;
		}
	}

	public void ride(int km)  {
		if (km > remaining) {
			throw new IllegalArgumentException("Ride to long!");
		} else {
			out.printf("Riding %d km%n", km);
			remaining = remaining - km;
		}
	}

	public int getRemainingMileage() {
		return remaining;
	}

	@Override
	public void close() throws IOException {
		out.println("Ride over for " + id);
	}
}
