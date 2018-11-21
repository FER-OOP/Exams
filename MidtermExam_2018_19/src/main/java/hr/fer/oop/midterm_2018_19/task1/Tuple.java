package hr.fer.oop.midterm_2018_19.task1;

import java.util.List;

public class Tuple<T> {
	private List<T> list;
	
			
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('(');		
		for(int i=0; i<list.size(); i++) {
			if (i != 0) {
				sb.append(", ");
			}
			sb.append(list.get(i).toString());
		}
		sb.append(')');
		return sb.toString();
	}
}
