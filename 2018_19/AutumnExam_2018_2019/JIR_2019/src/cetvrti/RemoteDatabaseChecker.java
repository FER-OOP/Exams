package cetvrti;

import java.util.List;

public class RemoteDatabaseChecker {
	public static List<String> getRemoteWarehouses() {
		return List.of("Zagreb", "Osijek", "Pula", "Vara�din", "�ibenik");
	}

	public static Integer checkRemoteForItem(String warehouse, String itemId) {
		// simulate long job
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (int) Math.random() * 10;
	}
}