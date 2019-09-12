package treci;

public class Panda implements Comparable<Panda> {
	private String name;
	private Integer weight;
	public Panda(String name, Integer weight) { this.name = name; this.weight = weight; }
	public Integer getWeight() {return weight;}
	public void eat(VirtualFood f) throws OverweightException {
		if (weight > 100) {
			f.setConsumed(false);
			throw new OverweightException(this.name + " has to go on a diet.");
		}
		f.setConsumed(true);
		this.weight = this.weight + 10;
		System.out.println(this.name + " gained weight and now has " + this.weight + " kg");
	}
	@Override public int compareTo(Panda o) {
		return Integer.compare(this.getWeight(), o.getWeight());
	}
	@Override public String toString() {return name + ":" + weight;}
	public String getName() { return name; }
}

