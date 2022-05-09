package hr.fer.oop;

import java.time.LocalDate;

public class Reading {
	
	private Integer deviceId;
	private SensorReadingValue [] sensorReadings;
	private LocalDate timestamp;
	
	public Reading(Integer deviceId, SensorReadingValue[] sensorReadings, LocalDate timestamp) {
		super();
		this.deviceId = deviceId;
		this.sensorReadings = sensorReadings;
		this.timestamp = timestamp;
	}
	
	public Integer getDeviceId() {
		return deviceId;
	}
	public SensorReadingValue[] getSensorReadings() {
		return sensorReadings;
	}
	public LocalDate getTimestamp() {
		return timestamp;
	}
	
//	@Override
//	public String toString() {
//		
//		StringBuilder s = new StringBuilder();
//		
//		s.append("deviceId: " + deviceId + "; timestamp: " + timestamp);
//		for(int i=0;i<sensorReadings.length;i++) {
//			if(sensorReadings[i] == null) 
//				s.append("; null");
//			else
//				s.append("; " + sensorReadings[i].getAttributeName() + ": " + sensorReadings[i].getAttributValue());
//		}
//		return s.toString();
//	}

}
