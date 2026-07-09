package hr.fer.oop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Arcade {
	
	 private final Map<String, GameRoom<? extends ArcadeMachine>> rooms =
	            new LinkedHashMap<>();

	    public void addRoom(GameRoom<? extends ArcadeMachine> room)
	            throws DuplicateException {
	        if (rooms.containsKey(room.getName())) {
	            throw new DuplicateException("Duplicate room.");
	        }
	        rooms.put(room.getName(), room);
	    }

	    public GameRoom<? extends ArcadeMachine> findRoom(String name) {
	        return rooms.get(name);
	    }

	    public int getTotalMachineCount() {
	        int count = 0;
	        for (GameRoom<? extends ArcadeMachine> room : rooms.values()) {
	            count += room.getMachines().size();
	        }
	        return count;
	    }

	    public ArcadeMachine findMachine(String code) {
	        for (GameRoom<? extends ArcadeMachine> room : rooms.values()) {
	            ArcadeMachine machine = room.findMachine(code);
	            if (machine != null) {
	                return machine;
	            }
	        }
	        return null;
	    }
}
