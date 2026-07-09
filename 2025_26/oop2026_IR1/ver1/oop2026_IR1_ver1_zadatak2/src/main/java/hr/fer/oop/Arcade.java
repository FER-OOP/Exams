package hr.fer.oop;

import java.util.LinkedHashMap;
import java.util.Map;

public class Arcade {
	
    private final Map<String, GameRoom<? extends ArcadeMachine>> rooms = new LinkedHashMap<>();

    
    public void addRoom(GameRoom<? extends ArcadeMachine> room) {
    	// TODO: The declaration may be changed where necessary.
    }

    
    public GameRoom<? extends ArcadeMachine> findRoom(String name) {
    	// TODO: Return the matching room or null.
    }

    public int getTotalMachineCount() {
    	// TODO
    }

    
    public ArcadeMachine findMachine(String code) {
    	// TODO: Return the matching machine or null.
    }
}
