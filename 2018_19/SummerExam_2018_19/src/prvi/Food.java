package prvi;

//TO DO: dopuniti zaglavlje klase
public class Food extends Item {
	private double weight;
	private final int TAX = 5; //(%)
	// TO DO: napisati metode klase Food koje nedostaju
	public Food(String name, String barcode, double netPrice, double weight) {
		super(name, barcode, netPrice);
		this.weight = weight;
	}	
	@Override public double getSalePrice() {
		return netPrice + (TAX/100.)*netPrice;
	}
}
