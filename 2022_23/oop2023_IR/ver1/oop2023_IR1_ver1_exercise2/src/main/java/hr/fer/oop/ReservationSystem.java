package hr.fer.oop;


public interface ReservationSystem {
	public boolean checkIfRoomAvailable(int roomNumber);
	public boolean bookRoom(int roomNumber, int numberOfGuests);
	public boolean cancelReservation(int roomNumber);
	public boolean modifyReservation(int roomNumber, int numberOfGuests);
    public int obtainAvailableRoomsCount();
    public String retrieveGuestList();
}
