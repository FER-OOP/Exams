package hr.fer.oop.summer_2020_21.task1;

public abstract class Payment
{
	private double amount;
	private int id;
	
	public Payment(double Amount, int id)
	{
		this.id = id;
		this.amount = Amount;
	}
	
	public double getAmount() {
		return amount;
	}
	public int getId() {
		return id;
	}
	

}
