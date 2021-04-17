package hr.fer.oop.midterm_2020_21.task4;
import static java.lang.System.out;

public class Main {
	public static void main(String[] args) throws Exception {
		Game g1 = null;
		Game g2 = null;
		VideoGame vg1 = null;
		VideoGame vg2 = null;

		try (Game g3 = new Game(10, "NFS")) {
			g1 = new VideoGame(100, "COD");
			vg1 = new VideoGame(0, "Cyberpunk 2077");
			vg2 = new VideoGame(3, "Minecraft");
			g2 = new Game(20, "Risk");			
		} 
		catch (NoCopiesException e) {
			out.println(e.getMessage());
		} 
		catch (Exception e) {
			out.println("Game sales exception");
		} 
		finally {
			out.println("Setup done");
			vg1 = new VideoGame(50, "Grim Dawn");
		}

		try {
			vg1.buyGame(5);
			vg2.buyGame(60);
			g1.buyGame(7);
		} 
		catch (NullPointerException e) {
			out.println("Null pointer exception");
		} 
		catch (Exception e) {
			out.println("Exception");
		} 
		finally {
			out.println("Sale finished!");
			((Game) vg1).close();
		}
		g1.buyGame(7);
		out.println(g1.numberOfCopies);
	}
}
