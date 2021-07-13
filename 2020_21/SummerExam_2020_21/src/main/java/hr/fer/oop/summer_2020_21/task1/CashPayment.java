package hr.fer.oop.summer_2020_21.task1;

public class CashPayment extends Payment
{
	private double receivedAmount;
	
	public CashPayment(double Amount, int id)
	{
		super(Amount, id);
		// TODO Auto-generated constructor stub
	}

	public double calculateChange()
	{
		return (this.receivedAmount - super.getAmount());
	}

}
