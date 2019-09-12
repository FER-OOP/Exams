package prvi;

//TO DO: dopuniti zaglavlje klase
public class Beverage extends Item {  
	private double volume;
	private final int TAX = 25; //(%)
	// TO DO: napisati metode klase Beverage koje nedostaju
	public Beverage(String name, String barcode, double netPrice, double volume) {
		super(name, barcode, netPrice);
		this.volume = volume;
	}
	@Override public double getSalePrice() {
		return netPrice + (TAX/100.)*netPrice;
	}	
}

