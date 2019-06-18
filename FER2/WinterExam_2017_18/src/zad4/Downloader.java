package zad4;

public class Downloader {

	public static boolean download(String url) {
		try {
			// Glumimo utrosak vremena za skidanje datoteke...
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Glumimo povremeni neuspjeh skidanja...
		if(Math.random() < 0.4) {
			return false;
		}
		return true;
	}
	
}
