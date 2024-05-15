package hr.fer.oop;


public class Bembo implements SafetyCar {
	
	private boolean isDeployed;
	private TrackConditions trackConditions;

	@Override
	public boolean deploySafetyCar() {
		if(isDeployed) return false;
		
		isDeployed = true;
		return true;
	}

	@Override
	public TrackConditions communicateWithRaceControl() {
		return trackConditions;		
	}

	@Override
	public boolean withdrawSafetyCar() {
		if(!isDeployed) return false;
		if(trackConditions != TrackConditions.OK) return false;
		
		isDeployed = false;
			
		return true;
	}

	@Override
	public void observeTrackConditions(TrackConditions rc) {
		this.trackConditions = rc;
	}

	@Override
	public Advice advise() {
		if(trackConditions== null) return Advice.NO_ADVICE;
		
		switch (trackConditions) {
		case BAD_WEATHER:
			return Advice.LIMIT_SPEED;
		case DEBRIS_ON_TRACK:
			return Advice.STOP_RACE;
		case OK:
			return Advice.GO_RACING;
		default:
			break;
		}
		
		return Advice.NO_ADVICE;
	}
	
	
	
}
