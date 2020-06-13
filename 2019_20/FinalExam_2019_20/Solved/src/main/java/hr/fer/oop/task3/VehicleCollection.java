package hr.fer.oop.task3;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

import hr.fer.oop.task2.Vehicle;

import java.util.TreeMap;

public class VehicleCollection implements Iterable<Pair<Vehicle, Integer>> {
	private Map<Vehicle, Integer> map = new TreeMap<>(Comparator.<Vehicle>naturalOrder().reversed());
	public void add(Vehicle vehicle) {
		Integer count = map.get(vehicle);
		count = count == null ? 1 : ++count;
		map.put(vehicle, count);		
	}
	
	public void add(Vehicle... vehicles) {
		for(Vehicle vehicle : vehicles)
			add(vehicle);			
	}

	public void remove(Vehicle vehicle) {
		Integer count = map.get(vehicle);
		if (count != null) {
			--count;
			if (count == 0)
				map.remove(vehicle);
			else
				map.put(vehicle, count);
		}			
	}

	@Override
	public Iterator<Pair<Vehicle, Integer>> iterator() {
		return new MyIterator();
	}

	private class MyIterator implements Iterator<Pair<Vehicle, Integer>> {		
		private Iterator<Map.Entry<Vehicle, Integer>> iterator;
		public MyIterator() {
			iterator = map.entrySet().iterator();
		}
		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		@Override
		public Pair<Vehicle, Integer> next() {
			var next = iterator.next();
			return new Pair<>(next.getKey(), next.getValue());
		}		
	}
}
