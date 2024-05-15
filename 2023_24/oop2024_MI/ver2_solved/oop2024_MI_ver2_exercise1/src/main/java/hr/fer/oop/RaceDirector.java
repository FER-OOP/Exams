package hr.fer.oop;


public interface RaceDirector {
	
	public boolean startRace();
	
	public Flag reportFlag();	

	public boolean stopRace();
	
	public Flag raiseFlag(Flag flag);
	
	public RaceStatus direct();
}
