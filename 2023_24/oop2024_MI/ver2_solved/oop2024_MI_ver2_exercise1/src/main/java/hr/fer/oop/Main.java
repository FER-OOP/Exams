package hr.fer.oop;


public class Main {
	
    public static void main(String[] args) {
    	
    	RaceDirector rd = new Paido();
    	
    	System.out.println("There should not be any race at this moment: "+rd.direct());
    	System.out.println("No flags raised (null): "+rd.reportFlag());
    	System.out.println("Race was not started so we cannot finish it, returning: " + rd.stopRace());
    	
    	System.out.println("Raising the green flag, previously should be non existent i.e. 'null': "+ rd.raiseFlag(Flag.GREEN));
    	System.out.println("Race successfully started? "+ rd.startRace());
    	
    	System.out.println("Race have green flag raised: "+rd.reportFlag());
    	
    	System.out.println("Race status should be IN PROGRESS: "+rd.direct());
    	
    	System.out.println("Race successfully finished? " + rd.stopRace());
    	
		// NOTE (opaska):
		// main does not cover all test cases (main ne pokriva sve testne slučajeve)
        
    }

}
