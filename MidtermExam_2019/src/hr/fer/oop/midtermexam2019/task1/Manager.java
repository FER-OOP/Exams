package hr.fer.oop.midtermexam2019.task1;

public class Manager extends Person{

	private Band managingBand;
	
	public Manager(String name, String country, int age, Band managingBand) {
		super(name, country, age);
		this.managingBand = managingBand;
	}

	public void kickBandMember(Musician musician) {
		Musician[] bandMembers = managingBand.getBandMembers();
		Musician[] reducedbandMembers = new Musician[bandMembers.length - 1];

		for (int i = 0, k = 0; i < bandMembers.length; i++) {
			if (musician.equals(bandMembers[i])) {
				continue;
			} else {
				reducedbandMembers[k++] = bandMembers[i];
			}
		}

		managingBand.setBandMembers(reducedbandMembers);

	}
	
	public Band getManagingBand() {
		return managingBand;
	}
	
}
