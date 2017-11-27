package hr.fer.oop.midterm_2017_18.task4;


public class BasicLifeCost {
	private double income;
	private double basicCost;
	
	public String getCostType(){
		return "Basic";
	}
	
	public BasicLifeCost(double income, double basicCost) {
		this.income = income;
		this.basicCost = basicCost;
	}

	public String toString() {
		if (totalCost() > income) {
			return "You can't afford to live... Total cost is " + totalCost();
		} 
		else {
			return "Total living cost is: " + totalCost();
		}
	}

	public double totalCost() {
		return basicCost;
	}
	
	public final double monthlySavings(){
		return income - totalCost();
	}
	
	public static void info(BasicLifeCost cost) {
		System.out.println("B: " + cost.getCostType());
	}
}
