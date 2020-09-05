package hr.fer.oop.task5;

import java.io.Closeable;
import java.io.IOException;

public class C implements Closeable {
	private Integer i = 0;

	public C() {
		System.out.println("created: " + i);
	}

	public C(Integer i) {
		this.i = i;
		System.out.println("created: " + i);
	}

	@Override
	public void close() throws IOException {
		System.out.println("close: " + this.i);
	}

	public void m(C other) {
		System.out.println("m: " + this.i / other.i);
	}

	public static void main(String[] args) {
		C c1 = new C(1);
		try (C c2 = new C(2)) {
			try (C c0 = new C(0); C c4 = null) {
				c1.m(c2);
				c1.m(c0);
				c2.m(new C());
				c0.m(c4);
			} catch (NullPointerException e) {
				System.out.println("NP exception");
			}
		} catch (Exception e) {
			System.out.println("exception");
		} finally {
			System.out.println("finally");
		}
		
		try {
			c1.close();
		} catch (IOException e) {
			System.out.println("IO exception");
		}
		
		System.out.println("end");
	}
}
