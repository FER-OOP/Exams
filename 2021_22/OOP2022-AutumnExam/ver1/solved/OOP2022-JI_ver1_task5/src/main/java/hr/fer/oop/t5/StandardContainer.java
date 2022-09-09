package hr.fer.oop.t5;

public class StandardContainer extends Container {

	private StandardContainerType type;
	
	public StandardContainer(String id, int volume, StandardContainerType type) {
		super(id, volume);
		this.type = type;
	}

	public StandardContainerType getType() {
		return type;
	}

	@Override
	public boolean add(int v) {
		if (type==StandardContainerType.MIXED  && v != 10 && v != 20 && v != 40)
				return false;
		return super.add(v);		
	}
	
}
