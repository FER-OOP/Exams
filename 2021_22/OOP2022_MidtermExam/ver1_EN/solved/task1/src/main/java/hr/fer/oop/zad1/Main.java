package hr.fer.oop.zad1;

public class Main {

	public static void main(String[] args) {
		CameraDrone spanishCD = new CameraDrone("SP-121", "1990-09-12", 1000, new int[]{100, 33});

		System.out.println(spanishCD.toString());
		System.out.println("The purpose of the drone is land photography and can cover an area of: " + spanishCD.coverArea(5.0)); // flying height is 5km
		System.out.println(spanishCD.aircraftStatus());

		CameraDrone croatianCD = new CameraDrone("HR-200", "2000-10-14", 1100, new int[]{100, 80, 90});

		System.out.println(croatianCD.toString());
		System.out.println("The purpose of the drone is land photography and can cover an area of: " + croatianCD.coverArea(4.5)); // flying height is 4.5km
		System.out.println(croatianCD.aircraftStatus());


		Plane plane = new Plane("Airbus A 320-200", "2001-03-04", 174, new int[] {100, 70, 95});
		System.out.println(plane.toString());
		System.out.println(plane.aircraftStatus());
		plane.setMotorsStatus(new int[]{100, 100, 100});
		System.out.println(plane.aircraftStatus());
	}

}
