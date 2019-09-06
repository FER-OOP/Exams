package prvi;

public class FoodItem {

	private String name;

	public FoodItem(String name) {
		if(name == null || name.equals("")){
			throw new IllegalArgumentException();
		}		
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
