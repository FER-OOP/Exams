package hr.fer.oop.zi.zad3;

import java.util.HashMap;
import java.util.Map;

public class Applicant {
    private final int id;
    private final String name;
    private Map<String, Double> requriedSkillScores = new HashMap<>();

    public Applicant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Applicant addRequiredSkillScore(String skill, double score) {
        this.requriedSkillScores.put(skill, score);
        return this;
    }

    public double getRequiredSkillScore(String skill) {
        return this.requriedSkillScores.getOrDefault(skill, 0.0);
    }

    public void applyFor(Position position) {
        position.addApplication(this);
    }
}

