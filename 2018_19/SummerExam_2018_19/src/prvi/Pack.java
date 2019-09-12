package prvi;

//TO DO: dopuniti zaglavlje klase
public class Pack extends Item {
	private Item [] itemsInPack;
	public Item[] getItemsInPack() { return itemsInPack; }
	// TO DO: napisati metode klase Pack koje nedostaju
	public Pack(String name, String barcode, Item [] itemsInPack) {
		super(name, barcode, itemsInPack[0].netPrice*itemsInPack.length);
		this.itemsInPack = itemsInPack;
	}
	@Override public double getSalePrice() {
		return itemsInPack.length*itemsInPack[0].getSalePrice();
	}
}

