package hr.fer.oop.task1;

import java.time.LocalDate;


public class Farmer extends HumanWorker<FarmerTools> {

	public Farmer(String oib, String name, LocalDate dateOfBirth) {
		super(oib, name, dateOfBirth);		
	}

	@Override
	protected double paymentCoef() {
		return 2;
	}


}
