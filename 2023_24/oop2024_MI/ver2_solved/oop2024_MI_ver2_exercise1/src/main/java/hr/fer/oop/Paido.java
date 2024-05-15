package hr.fer.oop;


public class Paido implements RaceDirector {
	
	private boolean isRaceInProgress;
	private Flag flag;

	@Override
	public boolean startRace() {
		
		if(isRaceInProgress || flag != Flag.GREEN) return false;
		
		isRaceInProgress = true;
		return isRaceInProgress;
	}

	@Override
	public Flag reportFlag() {
		
		return flag;
	}

	@Override
	public boolean stopRace() {
		if(!isRaceInProgress) return false;
		
		isRaceInProgress = false;
		return true;
	}

	@Override
	public Flag raiseFlag(Flag flag) {
		Flag old = this.flag;
		this.flag = flag;
		return old;
	}

	@Override
	public RaceStatus direct() {
		if(!isRaceInProgress) return RaceStatus.NO_RACE;
		
		switch (flag) {
		case GREEN:
			return RaceStatus.IN_PROGRESS;
		case RED:
			return RaceStatus.RED_FLAGGED;
		case YELLOW:
			return RaceStatus.RESTRICTED;

		default:
			break;
		}
		return RaceStatus.NO_RACE;
	}

}
