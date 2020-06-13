package hr.fer.oop.task5;

import java.io.IOException;
import static java.lang.System.out;

public class Car extends Vehicle {

	public Car(String id, int remaining) throws NoGasException {
		super(id, remaining);
	}

	@Override
	public void close() throws IOException {
		super.close();
		out.println("Car has finished the ride!");
	}
}
