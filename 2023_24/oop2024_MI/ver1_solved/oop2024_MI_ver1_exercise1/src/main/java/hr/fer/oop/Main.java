package hr.fer.oop;


public class Main {
	
    public static void main(String[] args) {
		SafetyCar sc = new Bembo();
		

		System.out.println("Advice without any info: "+sc.advise());
		

		System.out.println("Safety car deployed? "+sc.deploySafetyCar());
		
		System.out.println("Safety car deployed again? "+sc.deploySafetyCar());
		
		System.out.println("I currently observe nothing: "+sc.communicateWithRaceControl());
		System.out.println("Thereforem I do not have an advice: "+sc.advise());
		
		System.out.println("Observing debris on track...");
		sc.observeTrackConditions(TrackConditions.DEBRIS_ON_TRACK);
		System.out.println("Track conditions: "+sc.communicateWithRaceControl());
		
	
		
		
		boolean isWithdrawn = sc.withdrawSafetyCar();
		System.out.println("Because of this, you cannot withdrew me, returing: "+sc.withdrawSafetyCar());
		
		System.out.println("Imagine we observe OK conditions...");
		sc.observeTrackConditions(TrackConditions.OK);
		System.out.println("Now you can withdrew me, returing: "+sc.withdrawSafetyCar());
		System.out.println("Once withdrew, that is it, returning: "+sc.withdrawSafetyCar());
		
		// NOTE (opaska):
		// main does not cover all test cases (main ne pokriva sve testne slučajeve)
        
    }

}
