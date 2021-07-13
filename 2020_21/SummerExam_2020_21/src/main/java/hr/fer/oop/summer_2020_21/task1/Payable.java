package hr.fer.oop.summer_2020_21.task1;

public interface Payable <P extends Payment>
{
	public void pay(P paymentProcess);
	public double calculatePrice();

}
