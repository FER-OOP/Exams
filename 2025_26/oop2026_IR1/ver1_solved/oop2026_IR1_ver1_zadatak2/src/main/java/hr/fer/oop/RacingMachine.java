package hr.fer.oop;

public class RacingMachine extends ArcadeMachine {
    private final int maxSpeed;

    public RacingMachine(String code, String title, int requiredTokens,
                         int maxSpeed) {
        super(code, title, requiredTokens);
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String getMachineType() {
        return "Racing";
    }
}
