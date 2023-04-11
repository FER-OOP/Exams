package enumovi;

public class Demo {

		public static void main(String[] args) {
			Kolegij[] kolegiji = new Kolegij[] {
					new Kolegij("Strojno učenje", VrstaKolegija.TEORIJSKI),
					new Kolegij("Duboko učenje", VrstaKolegija.SPECIJALIZACIJA),
					new Kolegij("Bioinformatika", VrstaKolegija.IZBORNI)
			};
			
			for(Kolegij k : kolegiji) {
				VrstaKolegija vk = k.getVrstaKolegija();
				System.out.printf("Kolegij %s: tip=%d, opis: %s%n", k.getIme(), vk.getTip(), vk.getNaziv());
			}
		}
		
}
