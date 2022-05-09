package hr.fer.oop;

public class SensorReadingValue {
	
	private String attributeName;
	private Double attributValue;
	
	public SensorReadingValue(String attributeName, String attributeValue) {
		super();
		this.attributeName = attributeName;
		this.attributValue = Double.parseDouble(attributeValue);
	}

	public String getAttributeName() {
		return attributeName;
	}

	public Double getAttributValue() {
		return attributValue;
	}

}
