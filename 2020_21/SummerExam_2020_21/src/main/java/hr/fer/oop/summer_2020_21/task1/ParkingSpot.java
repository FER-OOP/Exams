package hr.fer.oop.summer_2020_21.task1;

public abstract class ParkingSpot
{
	private boolean occupied;
	private int id;
	private String position;
	
	public ParkingSpot(int id, String position)
	{
		this.id = id;
		this.position = position;
	}
	
	public boolean isOccupied()
	{
		return occupied;
	}
	public void takeSpot()
	{
		this.occupied = true;
	}
	public void releaseSpot()
	{
		this.occupied = false;
	}
	
	public int getID()
	{
		return this.id;
	}
	
	public String getPosition()
	{
		return this.position;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ParkingSpot)) {
			return false;
		}
		ParkingSpot other = (ParkingSpot) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

}
