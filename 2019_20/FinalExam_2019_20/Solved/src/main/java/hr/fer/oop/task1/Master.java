package hr.fer.oop.task1;

import java.time.LocalDate;


public class Master extends HumanWorker<MasterTools> {

	public Master(String oib, String name, LocalDate dateOfBirth) {
		super(oib, name, dateOfBirth);		
	}

	@Override
	protected double paymentCoef() {
		return 3;
	}


}
