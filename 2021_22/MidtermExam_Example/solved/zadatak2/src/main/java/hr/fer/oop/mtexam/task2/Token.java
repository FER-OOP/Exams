package hr.fer.oop.mtexam.task2;

abstract class Token {
	private double amount;
	private String name;

	Token(double amount, String name) {
		this.amount = amount;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public abstract String getTokenType();
}
