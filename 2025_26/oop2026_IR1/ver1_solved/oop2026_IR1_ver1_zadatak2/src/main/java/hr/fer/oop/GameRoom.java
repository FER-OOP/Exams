package hr.fer.oop;

import java.util.ArrayList;
import java.util.List;

public class GameRoom<T extends ArcadeMachine> {
    private final String name;
    private final List<T> machines = new ArrayList<>();

    public GameRoom(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addMachine(T machine) throws DuplicateException {
        for (T existingMachine : machines) {
            if (existingMachine.getCode().equals(machine.getCode())) {
                throw new DuplicateException("Duplicate machine.");
            }
        }
        machines.add(machine);
    }

    public List<T> getMachines() {
        return List.copyOf(machines);
    }

    public T findMachine(String code) {
        for (T machine : machines) {
            if (machine.getCode().equals(code)) {
                return machine;
            }
        }
        return null;
    }

    public List<T> getMachinesRequiringAtMost(int tokens) {
        List<T> result = new ArrayList<>();
        for (T machine : machines) {
            if (machine.getRequiredTokens() <= tokens) {
                result.add(machine);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return name + " (" + machines.size() + " machine(s))";
    }
}
