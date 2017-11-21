package hr.fer.oop.midterm_2017_18.task4;

public class Main {
	public static void main(String[] args) {
		ExtendedLifeCost cost1 = new ExtendedLifeCost(3500, 1800);		
		BasicLifeCost cost2 = new ExtendedLifeCost(3500, 1600);
		BasicLifeCost cost3 = new BasicLifeCost(3500, 2000);
		
		System.out.println(cost1); //You can't afford to live... Total cost is 3600.0
		System.out.println(cost2); //Total living cost is: 3200.0
		System.out.println(cost2.monthlySavings()); //300.0
		System.out.println(cost3); //Total living cost is: 2000.0
		System.out.println(cost3.monthlySavings()); //1500.0
		
		
		BasicLifeCost.info(cost1);
		BasicLifeCost.info(cost2);
		BasicLifeCost.info(cost3);
		ExtendedLifeCost.info(cost1);
		ExtendedLifeCost.info((ExtendedLifeCost) cost2);		
	}
	
}
