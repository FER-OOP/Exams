package osobe;

public class Student extends Osoba {

	private String fakultet;

	public Student(String ime, String fakultet) {
		super(ime);
		this.fakultet = fakultet;
	}
	
	public String getFakultet() {
		return fakultet;
	}
}
