package hr.fer.oop.jir2024.zad3;

public class Main {

	public static void main(String[] args) {

		SmallPackage sp1 = new SmallPackage(1500, 680, "sender1", "receiver1", Status.DRAFT, true);
		System.out.println(sp1); //Item from: sender1...
		
		LargePackage lp1 = new LargePackage(1500, 680, "sender2", "receiver2", Status.DRAFT, PackagingType.CARBOARD);
		System.out.println(lp1); // Item from: sender2...
				
		Letter l1 = null;
		try {
			
			l1 = new Letter(450, 200, "sender3", "receiver3");
			System.out.println(l1); // Item from: sender3...
		
		} catch (WeightLimitExceededException e) {
			System.out.println(e.getMessage());
		}

		Letter l2 = null;
		try {
			
			l2 = new Letter(550, 220, "sender4", "receiver1");
			System.out.println(l2);
		
		} catch (WeightLimitExceededException e) {
			System.out.println(e.getMessage()); // Weight limit exceeded!
		}

		System.out.println(lp1 instanceof Trackable); // true
		System.out.println(l1 instanceof Trackable); // true
		System.out.println(sp1 instanceof Trackable); // false
		
		System.out.println(lp1.getTrackingInformation()); // Tracking information not available
		lp1.setTrackingNumber(123);
		System.out.println(lp1.getTrackingInformation()); // Tracking number: 123

	}

}
