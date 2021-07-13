package hr.fer.oop.summer_2020_21.task1;

public class ChargingSpot extends ParkingSpot
{
	private double kWhCount;
	private boolean quickchargeSupported;
	private String IP;
	
	public ChargingSpot(boolean quickChargeSupported, String IP, int id, String position)
	{
		super(id, position);
		this.IP = IP;
		this.quickchargeSupported = quickChargeSupported;
	}
	
	public double getkWhCount()
	{
		return kWhCount;
	}
	
	public String getIP()
	{
		return this.IP;
	}
	
	public boolean isQuickchargeSupported()
	{
		return quickchargeSupported;
	}
	
}
