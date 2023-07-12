package hr.fer.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

class Solution implements ReservationSystem {
	int totalRooms;
	boolean[] roomAvailable;
	int[] numberOfGuests;
	
	public Solution(int totalRooms) {
		this.totalRooms = totalRooms;
		this.roomAvailable = new boolean[totalRooms];
		this.numberOfGuests = new int[totalRooms];
		
		for(int index=0; index < roomAvailable.length; index++) {
			roomAvailable[index] = true;
			numberOfGuests[index] = 0;
		}
	}

	private boolean validRoomNumber(int roomNumber) {
		return ((roomNumber > 0) && ((roomNumber-1) < roomAvailable.length));
	}
	
	@Override
	public boolean checkIfRoomAvailable(int roomNumber) {
		if (validRoomNumber(roomNumber))
			return roomAvailable[roomNumber-1];
		else
			return false;
	}

	@Override
	public boolean bookRoom(int roomNumber, int numberOfGuests) {
		if (checkIfRoomAvailable(roomNumber) && (numberOfGuests > 0)) {
			roomAvailable[roomNumber-1] = false;
			this.numberOfGuests[roomNumber-1] = numberOfGuests;
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean cancelReservation(int roomNumber) {
		if (!checkIfRoomAvailable(roomNumber) && validRoomNumber(roomNumber)) {
			roomAvailable[roomNumber-1] = true;
			this.numberOfGuests[roomNumber-1] = 0;
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean modifyReservation(int roomNumber, int numeberOfGuests) {
		if (!checkIfRoomAvailable(roomNumber) && validRoomNumber(roomNumber)) {
			if((numeberOfGuests > 0) && (this.numberOfGuests[roomNumber-1] != numeberOfGuests)) {
				numberOfGuests[roomNumber-1] = numeberOfGuests;
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}

	@Override
	public int obtainAvailableRoomsCount() {
		int availabeRoomsCount = 0;
		for (boolean available: roomAvailable) {
			if (available)
				availabeRoomsCount++;
		}
		return availabeRoomsCount;
		
	}

	@Override
	public String retrieveGuestList() {
        List<String> guests = new ArrayList<>();
    	
    	for(int index=0; index < roomAvailable.length; index++) {
            if (!checkIfRoomAvailable(index+1))
            	guests.add(String.format("Room %d:%d", index+1, numberOfGuests[index]));
		}
    	  
        String guestList = "";
        for (Iterator<String> it = guests.iterator(); it.hasNext();) {
	    	String guest = it.next();
	    	if(it.hasNext())
	    		guestList += String.format("%s;", guest);
	    	else
	    		guestList += String.format("%s", guest);
        }
        return guestList;
	}
	
}
