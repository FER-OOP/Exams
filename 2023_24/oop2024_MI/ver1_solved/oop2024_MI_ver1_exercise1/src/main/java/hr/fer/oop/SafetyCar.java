package hr.fer.oop;


public interface SafetyCar {
	
	public boolean deploySafetyCar();
	
	public TrackConditions communicateWithRaceControl();
	
	public boolean withdrawSafetyCar();
	
	public void observeTrackConditions(TrackConditions rc);
	
	public Advice advise();
	
}
