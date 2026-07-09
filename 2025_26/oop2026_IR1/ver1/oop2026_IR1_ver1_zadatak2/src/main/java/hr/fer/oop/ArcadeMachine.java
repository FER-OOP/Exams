package hr.fer.oop;

public abstract class ArcadeMachine {
    private final String code;
    private final String title;
    private final int requiredTokens;

    public ArcadeMachine(String code, String title, int requiredTokens) {
        this.code = code;
        this.title = title;
        this.requiredTokens = requiredTokens;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getRequiredTokens() {
        return requiredTokens;
    }

    public abstract String getMachineType();

    @Override
    public String toString() {
        return "[" + code + "] " + title
                + " (" + getMachineType() + ") - "
                + requiredTokens + " token(s)";
    }
}