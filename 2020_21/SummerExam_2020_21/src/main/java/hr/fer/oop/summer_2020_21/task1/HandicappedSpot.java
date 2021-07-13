package hr.fer.oop.summer_2020_21.task1;

public class HandicappedSpot extends ParkingSpot
{
	private boolean wideSpot;
	
	public HandicappedSpot(int id, String position, boolean wideSpot)
	{
		super(id, position);
		// TODO Auto-generated constructor stub
		this.wideSpot = wideSpot;
	}

}
