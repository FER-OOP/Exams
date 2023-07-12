package hr.fer.oop;

public class Main {
    public static void main(String[] args) {
        int totalRooms = 10;
        ReservationSystem reservationSystem = new Solution(totalRooms);

        System.out.println("Is room 1 available? " + reservationSystem.checkIfRoomAvailable(1));
        System.out.println("Available rooms count: " + reservationSystem.obtainAvailableRoomsCount());

        boolean booked = reservationSystem.bookRoom(2, 2);
        System.out.println("Booking in progress... result for room 2? " + booked);

        booked = reservationSystem.bookRoom(5, 1);
        System.out.println("Booking in progress... result for room 5? " + booked);

        booked = reservationSystem.bookRoom(8, 3);
        System.out.println("Booking in progress... result for room 8? " + booked);

        System.out.println("Is room 2 available? " + reservationSystem.checkIfRoomAvailable(2));
        System.out.println("Available rooms count: " + reservationSystem.obtainAvailableRoomsCount());

        boolean modified = reservationSystem.modifyReservation(5, 2);
        System.out.println("Modified reservation for room 5? " + modified);


        System.out.println("Is room 5 available? " + reservationSystem.checkIfRoomAvailable(5));

        boolean canceled = reservationSystem.cancelReservation(3);
        System.out.println("Canceled reservation for room 3? " + canceled);


        System.out.println("Is room 3 available? " + reservationSystem.checkIfRoomAvailable(3));
        System.out.println("Available rooms count: " + reservationSystem.obtainAvailableRoomsCount());

        booked = reservationSystem.bookRoom(7, 1);
        System.out.println("Booking in progress... result for room 7? " + booked);

        System.out.println("Is room 7 available? " + reservationSystem.checkIfRoomAvailable(7));
        System.out.println("Available rooms count: " + reservationSystem.obtainAvailableRoomsCount());

        System.out.println("Guest List:\n" + reservationSystem.retrieveGuestList());
    }

}
