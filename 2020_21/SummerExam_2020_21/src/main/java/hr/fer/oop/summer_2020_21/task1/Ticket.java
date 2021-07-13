package hr.fer.oop.summer_2020_21.task1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Ticket implements Payable<Payment>
{
	private boolean paid;
	private LocalDateTime entranceDate;
	private ParkingSpot parkingSpot;
	private int id;
	
	public Ticket(ParkingSpot parkingSpot)
	{
		this.paid = false;
		this.entranceDate = java.time.LocalDateTime.now();
		this.id = parkingSpot.getID() + entranceDate.toString().hashCode();
		this.parkingSpot = parkingSpot;
	}
	
	public void setPaid()
	{
		this.paid = true;
	}
	
	public boolean isPaid()
	{
		return paid;
	}
	
	public int getID()
	{
		return this.id;
	}
		
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Ticket)) {
			return false;
		}
		Ticket other = (Ticket) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public double calculatePrice()
	{
		//calculate hours
		LocalDateTime currentDate = java.time.LocalDateTime.now();
		long hours = ChronoUnit.HOURS.between(entranceDate, currentDate);
		if(this.parkingSpot instanceof ChargingSpot) return(((ChargingSpot) this.parkingSpot).getkWhCount()*1.25 + 10*hours);
		if(this.parkingSpot instanceof StandardSpot) return (10*hours);
		else return 0.0;
		
	}

	@Override
	public void pay(Payment paymentProcess)
	{
		// TODO Auto-generated method stub
		
	}
	
}
