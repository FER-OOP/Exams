package hr.fer.oop.midtermexam2019.task1;

public class Band {

	private Musician[] bandMembers;
	private String bandName;

	public Band(Musician[] bandMembers, String name) {
		this.bandMembers = bandMembers;
		this.bandName = name;
	}

	public Musician[] getBandMembers() {
		return bandMembers;
	}

	public String getBandName() {
		return bandName;
	}

	public void setBandMembers(Musician[] bandMembers) {
		this.bandMembers = bandMembers;

	}

	@Override
	public String toString() {
		String info = "Members of the band " + this.getBandName() + " are:";
		for (int i = 0; i < bandMembers.length; i++) {
			if (i != bandMembers.length - 1)
				info += " " + bandMembers[i].getName() + ",";
			else
				info += " " + bandMembers[i].getName();
		}
		return info;
	}
}
