package hr.fer.oop;

public class RhythmMachine extends ArcadeMachine {
    private final int songCount;

    public RhythmMachine(String code, String title, int requiredTokens,
                         int songCount) {
        super(code, title, requiredTokens);
        this.songCount = songCount;
    }

    public int getSongCount() {
        return songCount;
    }

    @Override
    public String getMachineType() {
        return "Rhythm";
    }
}
