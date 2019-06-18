package hr.fer.oop.midtermexam2019.task1;

public class Musician extends Person{

	private Integer skill;
	private BandPosition bandPosition;
	
	public Musician(String name, String country, int age, BandPosition bandPosition, Integer skill) {
		super(name, country, age);
		this.bandPosition = bandPosition;
		this.skill = skill;
	}
	
	public void trainForOneYear() {
		this.setSkill(skill + 1);
		this.setAge(this.getAge() + 1);
	}

	public Integer getSkill() {
		return skill;
	}
	
	public void setSkill(Integer skill) {
		this.skill = skill;
	}

	public BandPosition getBandPosition() {
		return bandPosition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bandPosition == null) ? 0 : bandPosition.hashCode());
		result = prime * result + ((skill == null) ? 0 : skill.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musician other = (Musician) obj;
		if (bandPosition != other.bandPosition)
			return false;
		if (skill == null) {
			if (other.skill != null)
				return false;
		} else if (!skill.equals(other.skill))
			return false;
		return true;
	}

}
