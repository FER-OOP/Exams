package prvi;

//TO DO: dopuniti zaglavlje klase
public abstract class Item implements Barcoded {
	private String name;
	private String barcode;
	protected double netPrice;  // neto cijena
	public String getName() { return name; }
	public Item(String name, String barcode, double netPrice) {
		this.name = name; this.barcode = barcode;	this.netPrice = netPrice;
		
	}
	// TO DO: napisati metode klase Item koje nedostaju 
	public abstract double getSalePrice();
	//public double getSalePrice() {return 0;} // priznati i ovakvo rješenje

	@Override public String barcode() {	return barcode; }
		
	@Override public int hashCode() {
		int result = ((barcode == null) ? 0 : barcode.hashCode())
				+ ((name == null) ? 0 : name.hashCode())
				+ Double.valueOf(netPrice).hashCode();
		return result;
	}

    //@Override public int hashCode() { //priznati i ovakvo rješenje
	//	return Objects.hash(barcode, name, netPrice);
	//}


	@Override public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Item))
			return false;
		Item other = (Item) obj;
		
		return this.barcode.equals(other.barcode) &&
			 this.name.equals(other.name) && 
		Double.valueOf(this.netPrice).equals(Double.valueOf(other.netPrice));
	}

	@Override public String toString() {
		return String.format("%s %s Net:%.2f Sale:%.2f",
                                   name, barcode, netPrice, getSalePrice());
	}	
}

