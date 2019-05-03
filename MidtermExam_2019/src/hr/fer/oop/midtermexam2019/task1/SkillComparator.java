package hr.fer.oop.midtermexam2019.task1;

import java.util.Comparator;

public class SkillComparator implements Comparator<Musician>{

	@Override
	public int compare(Musician m1, Musician m2) {
		if(m1.getSkill() == m2.getSkill())
			return 0;
		else if(m1.getSkill()>m2.getSkill())
			return 1;
		else
			return -1;
	}

}
