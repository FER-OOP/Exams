package hr.fer.oop.ZI2024.zad2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChessPlayerData {
	public static List<ChessPlayer> loadChessPlayersTop() {
		
		List<ChessPlayer> players = new ArrayList<>();
		
		players.add(new ChessPlayer("Magnus", "Carlsen", Country.NORWAY, 2830, 1990));
		players.add(new ChessPlayer("Fabiano", "Caruana", Country.USA, 2805, 1992));
		players.add(new ChessPlayer("Hikaru", "Nakamura", Country.USA, 2794, 1987));
		players.add(new ChessPlayer("Ian", "Nepomniachtchi", Country.RUSSIA, 2770, 1990));
		players.add(new ChessPlayer("Nodirbek", "Abdusattorov", Country.UZBEKISTAN, 2766, 2004));
		players.add(new ChessPlayer("Gukesh", "Dommaraju", Country.INDIA, 2763, 2006));
		players.add(new ChessPlayer("Liren", "Ding", Country.CHINA, 2762, 1992));
		players.add(new ChessPlayer("Arjun", "Erigaisi", Country.INDIA, 2761, 2003));
		players.add(new ChessPlayer("So", "Wesley", Country.USA, 2757, 1993));
		players.add(new ChessPlayer("Yi", "Wei", Country.CHINA, 2755, 1999));
		players.add(new ChessPlayer("Viswanathan", "Anand", Country.INDIA, 2751, 1969));
		players.add(new ChessPlayer("Leinier", "Dominguez Perez", Country.USA, 2748, 1983));
		players.add(new ChessPlayer("Rameshbabu", "Praggnanandhaa", Country.INDIA, 2747, 2005));
		players.add(new ChessPlayer("Anish", "Giri", Country.NEDERLANDS, 2745, 1994));
		players.add(new ChessPlayer("Alireza", "Firouzja", Country.FRANCE, 2737, 2003));
		players.add(new ChessPlayer("Shakhriyar", "Mamedyarov", Country.AZERBAIJAN, 2734, 1985));
		players.add(new ChessPlayer("Parham", "Maghsoodloo", Country.IRAN, 2733, 2000));
		players.add(new ChessPlayer("Duda", "Jan-Krzysztof", Country.POLAND, 2733, 1998));
		players.add(new ChessPlayer("Maxime", "Vachier-Lagrave", Country.FRANCE, 2732, 1990));
		players.add(new ChessPlayer("Quang Liem", "Le", Country.VIETNAM, 2731, 1991));
		
		Collections.shuffle(players);
		
		return players;
	}
	
	public static List<ChessPlayer> loadChessPlayersCro() {
		
		List<ChessPlayer> players = new ArrayList<>();
		
		players.add(new ChessPlayer("Ivan", "Šarić", Country.CROATIA, 2690, 1990));
		players.add(new ChessPlayer("Ante", "Brkić", Country.CROATIA, 2645, 1988));
		players.add(new ChessPlayer("Saša", "Martinović", Country.CROATIA, 2563, 1991));
		players.add(new ChessPlayer("Alojzije", "Janković", Country.CROATIA, 2554, 1983));
		players.add(new ChessPlayer("Marin", "Bosiočić", Country.CROATIA, 2553, 1988));
		players.add(new ChessPlayer("Leon", "Livaić", Country.CROATIA, 2547, 2000));
		players.add(new ChessPlayer("Zlatko", "Topalović", Country.CROATIA, 2539, 1965));
		players.add(new ChessPlayer("Davorin", "Kuljašević", Country.CROATIA, 2539, 1986));
		players.add(new ChessPlayer("Hrvoje", "Stević", Country.CROATIA, 2531, 1980));
		players.add(new ChessPlayer("Zoran", "Jovanović", Country.CROATIA, 2526, 1979));
		players.add(new ChessPlayer("Zdenko", "Kožul", Country.CROATIA, 2515, 1966));
		players.add(new ChessPlayer("Ante", "Šarić", Country.CROATIA, 2509, 1984));
		players.add(new ChessPlayer("Ognjen", "Jovanić", Country.CROATIA, 2492, 1978));
		players.add(new ChessPlayer("Goran", "Dizdar", Country.CROATIA, 2483, 1958));
		players.add(new ChessPlayer("Dražen", "Sermek", Country.CROATIA, 2471, 1969));
		players.add(new ChessPlayer("Vlatko", "Kovačević", Country.CROATIA, 2466, 1942));
		players.add(new ChessPlayer("Mirko", "Jukić", Country.CROATIA, 2461, 1962));
		players.add(new ChessPlayer("Mladen", "Palac", Country.CROATIA, 2460, 1971));
		players.add(new ChessPlayer("Robert", "Zelčić", Country.CROATIA, 2453, 1965));
		players.add(new ChessPlayer("Dražen", "Čvorović", Country.CROATIA, 2432, 1988));
		
		Collections.shuffle(players);
		
		return players;
	}
	
	public static List<ChessPlayer> loadChessPlayersSmall() {
		
		List<ChessPlayer> players = new ArrayList<>();
		
		players.add(new ChessPlayer("Goran", "Višnjić", Country.CROATIA, 1500, 1972));
		players.add(new ChessPlayer("Goran", "Višnjić", Country.CROATIA, 1600, 1972));
		players.add(new ChessPlayer("Ivan", "Ćupić", Country.CROATIA, 1500, 1986));
		players.add(new ChessPlayer("Ivan", "Ćupić", Country.CROATIA, 1700, 1986));
		players.add(new ChessPlayer("Ivan", "Šarić", Country.CROATIA, 2690, 1990));
		players.add(new ChessPlayer("Ante", "Šarić", Country.CROATIA, 2509, 1984));
		players.add(new ChessPlayer("Brandon", "Lee", Country.USA, 1997, 1973));
		players.add(new ChessPlayer("Magnus", "Carlsen", Country.NORWAY, 2830, 1990));
		Collections.shuffle(players);
		
		return players;
	}
}
