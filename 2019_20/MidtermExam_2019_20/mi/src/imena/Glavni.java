package imena;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class Glavni {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		List<String> imena = new ArrayList<>();
		while(sc.hasNext()) {
			String s = sc.next();
			if(s.equals("kraj")) break;
			imena.add(s);
		}
		
		if(imena.isEmpty()) {
			System.out.println("Niste dali niti jedno ime.");
			return;
		}
		
		int d = prosjecnaDuljina(imena);
		
		System.out.println("Ispis 1 (prosječna duljina: "+d+"):");
		List<String> nova = new ArrayList<String>();
		for(String ime : imena) {
			if(ime.length() >= d) nova.add(ime);
		}
		nova.sort(null);
		
		for(String ime : nova) System.out.println(ime);

		System.out.println("Ispis 2:");
		for(String ime : new LinkedHashSet<>(imena)) {
			System.out.println(ime);
		}
	}

	private static int prosjecnaDuljina(List<String> imena) {
		int suma = 0;
		for(String ime : imena) suma += ime.length();
		return (int)(suma/(double)imena.size()+0.5);
	}

}
