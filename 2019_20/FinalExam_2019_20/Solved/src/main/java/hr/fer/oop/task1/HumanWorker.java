package hr.fer.oop.task1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class HumanWorker<T extends Tool> extends Person implements Resource {
	private int hours = 0;
	protected List<WorkerTool<T>> boxOfTools = new ArrayList<>();
	
	public HumanWorker(String oib, String name, LocalDate dateOfBirth) {
		super(oib, name, dateOfBirth);		
	}
	
	protected abstract double paymentCoef();
	
	public double payment(int pricePerHour) {
		return pricePerHour * paymentCoef() * getHours();
	}
	
	@Override
	public int getHours() {
		return hours;
	}
	
	@Override
	public void addHours(int hours) {
		this.hours += hours;		
	}
	
	@Override
	public void resetHours() {
		hours = 0;		
	}
}
