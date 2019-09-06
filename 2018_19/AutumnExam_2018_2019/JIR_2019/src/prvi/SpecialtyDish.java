package prvi;

import java.util.HashMap;
import java.util.Map;

public class SpecialtyDish {

	private Map<FoodItem, AmountAndUnit> items;
	private Type type;
	
	public SpecialtyDish(Type type) {
		this.items = new HashMap<FoodItem, AmountAndUnit>();
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}
	
	public Map<FoodItem, AmountAndUnit> getItems() {
		return items;
	}
	
	public void addFoodItem (FoodItem foodItem, AmountAndUnit amountAndUnit){
		if(items == null){
			this.items = new HashMap<FoodItem, AmountAndUnit>();
		}
		items.put(foodItem, amountAndUnit);
	}
	
	public void checkVeganFriendly(){
		if(this.type != Type.VEGAN) throw new WrongFoodTypeException();
	}
	
}
