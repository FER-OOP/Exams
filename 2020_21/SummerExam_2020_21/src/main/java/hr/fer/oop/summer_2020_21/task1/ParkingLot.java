package hr.fer.oop.summer_2020_21.task1;

//import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

public class ParkingLot
{
//	private LocalDateTime date;
	private ArrayList<Ticket> ticketList;
	private HashSet<ParkingSpot> parkingSpotSet;
	
	public void addTicket(Ticket t)
	{
		this.ticketList.add(t);
	}
	
	public void addSpot(ParkingSpot s)
	{
		this.parkingSpotSet.add(s);
	}
	
	public Ticket getTicket(int id)
	{
		int i = 0;
		
		for(Ticket t : this.ticketList)
		{
			if(t.getID()== id) 	return this.ticketList.get(i);
		}
		
		return null;
	}
	
	
	public Ticket enterLot()
	{
		//For now use standard spot 
		String s = "Standard";
		
		//Placeholder for some fancy algorithm - finding best of available spots...
	     for(ParkingSpot temp : parkingSpotSet)
	     {
	    	 if(!temp.isOccupied() && temp.getPosition().equals("any"))
	    	 {
	    		 if(s.equals("Standard") && (temp instanceof StandardSpot))
	    		 {
		    		 return new Ticket(temp); 
	    		 }
	    		 
	    		 if(s.equals("Handicapped") && (temp instanceof HandicappedSpot))
	    		 {
		    		 return new Ticket(temp); 
	    		 }
	    		 if(s.equals("Charging") && (temp instanceof ChargingSpot))
	    		 {
		    		 return new Ticket(temp); 
	    		 }
	    	 }
	     }
	     return null;
	}
	
	public void exitLot(Ticket ticket)
	{
		if(ticket.isPaid())
		{
			//releaseRamp();
		}
	}
}
