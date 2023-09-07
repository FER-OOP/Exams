package hr.fer.oop;

public class CubeBox extends ToyBox<Cube> {

	private final int maxVolume;
	
	public CubeBox(int maxWeight, int maxVolume) {
		super(maxWeight);
		this.maxVolume = maxVolume;		
	}

	public int getMaxVolume() {
		return maxVolume;
	}

	@Override
	public void put(Cube c) {
			//ovo je sporiji nacin i malo ruzniji, ali moze i tako...
			//provjerim samo za volumen i ako je ok, pozovem super put
			int currVolume = this.toys.stream().mapToInt( t -> {int w = ((Cube)t).getWidth(); return w*w*w;}).sum();
			if (currVolume+(c.getWidth()*c.getWidth()*c.getWidth()) > maxVolume)	
					throw new ToyBoxOperationException("Box is full");
			super.put(c);
	}

}
