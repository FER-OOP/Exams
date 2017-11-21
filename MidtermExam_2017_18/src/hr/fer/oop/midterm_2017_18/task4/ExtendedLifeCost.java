package hr.fer.oop.midterm_2017_18.task4;

public class ExtendedLifeCost extends BasicLifeCost {
	private double additionalExpenses;
	
	public String getCostType(){
		return "Extended";
	}

	public ExtendedLifeCost(double income, double basicCost, double additionalExpenses) {
		super(income, basicCost);
		this.additionalExpenses = additionalExpenses;
	}
	
	public ExtendedLifeCost(double income, double basicCost) {
		//additionalExpenses are equal to basicCost
		this(income, basicCost, basicCost);		
	}

	public double totalCost() {
		return super.totalCost() + additionalExpenses;
	}
	
	public static void info(ExtendedLifeCost cost) {
		System.out.println("E: " + cost.getCostType());
	}
}
