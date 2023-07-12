package hr.fer.oop;

public class Main {
	
    public static void main(String[] args) {
        Bicycle bike = new Bicycle("Bike A", 2);
        Car car = new Car("Car A", 7.4);
        
        AbstractTransport[] transportDevices = {bike, car}; 
        
        for(AbstractTransport device : transportDevices) {
        	System.out.println("-----");
        	System.out.println(device);
        	System.out.println(device.move());
        	System.out.printf("CO2 in kg for 10 kilometers: %.1f",device.calculateCO2(10));
        }  
    }

}
