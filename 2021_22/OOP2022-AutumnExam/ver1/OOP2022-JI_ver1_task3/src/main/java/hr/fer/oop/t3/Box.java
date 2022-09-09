package hr.fer.oop.t3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Box<T> {
	protected List<T> content;
	public List<T> boxContent() {
		return Collections.unmodifiableList(content);
	}
	public Box(Collection<? extends T> elements) {
		content = new ArrayList<>(elements);
	}
}
 