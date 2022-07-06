package hr.fer.oop.zi.zad3;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class Position {

    private final String name;
    private List<RequiredSkill> requiredSkills = new ArrayList<>();
    // TODO: Create a collection of oredered Application objects, called 'applications'

    public Position(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Position addRequiredSkill(RequiredSkill skill) {
    	this.requiredSkills.add(skill);
        return this;
    }

    public void addApplication(Applicant applicant) {
        // TODO: Add application
    }
    
    public Collection<Application> getApplications() {
        // TODO: return 'applications'
    }

    public String summarizeApplications() {
        StringBuilder builder = new StringBuilder(this.name);
        builder.append(':');
        
        // TODO: Iterate over applications and add lines for all of the
        // applications. Applications have to be ordered from the one with the greates score
        // to the one with the lowest.
        return builder.toString();
    }

}