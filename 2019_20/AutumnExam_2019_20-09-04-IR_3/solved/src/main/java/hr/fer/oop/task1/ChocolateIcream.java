package hr.fer.oop.task1;

public class ChocolateIcream extends Icecream {

	private short chocolatePercentage;
	private ChocolateType chocolateType;
	
	public short getChocolatePercentage() {
		return chocolatePercentage;
	}
	
	public void setChocolatePercentage(short chocolatePercentage) {
		this.chocolatePercentage = chocolatePercentage;
	}
	
	public ChocolateType getChocolateType() {
		return chocolateType;
	}
	
	public void setChocolateType(ChocolateType chocolateType) {
		this.chocolateType = chocolateType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((chocolateType == null) ? 0 : chocolateType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChocolateIcream other = (ChocolateIcream) obj;
		if (chocolateType != other.chocolateType)
			return false;
		return true;
	}
	
	
	
}
