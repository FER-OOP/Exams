package hr.fer.oop;


public class Camper implements Trailer {

	private MotorVehicle attachedTo;

public Camper() {
  }

  @Override
  public void attachTo(MotorVehicle vehicle) {
    attachedTo = vehicle;
  }

  @Override
  public String toString() {
    if(attachedTo == null) return "Camper not attached to any motor vehicle";
    return String.format("Camper attached to '%s'", attachedTo.getModel());
  }
}
 
