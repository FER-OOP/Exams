package hr.fer.oop;


public interface Nutritional {
	public int getFat();
	public int getCarbs();
	public int getProtein();
	
	public default int getCalories() {
		return (getCarbs()+getProtein())*4 +getFat()*9;
	}

}
