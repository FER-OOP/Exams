package treci;

import java.io.Closeable;
import java.io.IOException;

public class VirtualFood implements Closeable {
	int id;
	boolean consumed;

	public void setConsumed(boolean consumed) {
		this.consumed = consumed;
	}

	public VirtualFood(int id) {
		this.id = id;
	}

	@Override
	public void close() throws IOException {
		System.out.println("Closing food resource " + id);
		if (!consumed)
			throw new RuntimeException("Food " + id + " is not consumed");
	}

	public int getId() {
		return id;
	}
}
