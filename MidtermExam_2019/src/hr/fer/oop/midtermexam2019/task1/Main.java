package hr.fer.oop.midtermexam2019.task1;

public class Main {

	public static void main(String[] args) {

		Musician m1 = new Musician("Dave Grohl", "USA", 50, 
				BandPosition.SINGER, 98);
		Musician m2 = new Musician("Pat Smear", "USA", 59, 	
				BandPosition.GUITARIST, 85);
		Musician m3 = new Musician("Chris Shiflett", "USA", 47, 
				BandPosition.GUITARIST, 85);
		Musician m4 = new Musician("Nate Mendel", "USA", 50, 
				BandPosition.BASSIST, 93);
		Musician m5 = new Musician("Taylor Hawkins", "USA", 47, 
				BandPosition.SINGER, 70);
		Musician m6 = new Musician("Rami Jaffee", "USA", 50, 
				BandPosition.PIANIST, 72);
		
		Musician[] musicians1 = new Musician[] {m1,m2,m3,m4,m5,m6};
		
		Band b1 = new Band(musicians1, "Foo Fighters");
		
		Manager manager = new Manager("Steven Howard", "USA", 67, b1);
		
		System.out.println(b1);
		
		manager.kickBandMember(m6);
		
		System.out.println(b1);
		
		System.out.println("Band member " + m3.getName() + " before training: "
				+ "Age: " + m3.getAge() + " Skill: " + m3.getSkill());
		
		m3.trainForOneYear();
		
		System.out.println("Band member " + m3.getName() + " after training: "
				+ "Age: " + m3.getAge() + " Skill: " + m3.getSkill());
		
		Event c1 = new Concert("PulaConcert", "Croatia", 
				"19 June", 
				b1, new String[] {"Best of You", "My Hero", 
						"Big Me"}); 
		
		System.out.println("----CONCERT POSTER----");
		((EventPromoter) c1).printEventPoster();
		
		Musician m7 = new Musician("Dan Auerbach", "USA", 39, 
				BandPosition.SINGER, 98);
		Musician m8 = new Musician("Patrick James Carney", "USA", 38, 
				BandPosition.DRUMMER, 97);
		
		Musician[] musicians2 = new Musician[] {m7, m8};
		
		Band b2 = new Band(musicians2, "The Black Keys");
		
		Person m9 = new Musician("Jack Black", "USA", 49, 
				BandPosition.SINGER, 100);
		Person m10 = new Musician("Kyle Gass", "USA", 58, 
				BandPosition.GUITARIST, 100);
		
		Person p1 = new Person("Goran Bare", "Croatia", 53);
		
		Band b3 = new Band(new Musician[] {(Musician) m9,  (Musician) m10}, 
				"Tenacious D");
		
		Band[] bands = new Band[] {b1, b2, b3};
		
		Event f1 = new Festival("Rock in Croatia", "Zagreb", 
				"5 June", bands);
		System.out.println("----FESTIVAL POSTER----");
		((EventPromoter) f1).printEventPoster();
		
	}
}
