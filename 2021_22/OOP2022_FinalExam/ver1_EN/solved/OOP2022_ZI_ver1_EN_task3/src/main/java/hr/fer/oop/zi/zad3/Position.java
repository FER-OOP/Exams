package hr.fer.oop.zi.zad3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Position {

    private final String name;
    private List<RequiredSkill> requiredSkills = new ArrayList<>();
    private Set<Application> applications = new TreeSet<>(
    		Comparator.comparing(Application::getScore)
    		.reversed()
    		.thenComparing(app -> app.getApplicant().getId()));

    public Position(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Position addRequiredSkill(RequiredSkill requirement) {
        this.requiredSkills.add(requirement);
        return this;
    }


    public double scoreFor(Applicant applicant) {
        double sum = 0.0;
        for(RequiredSkill requirement : requiredSkills) {
            double score = applicant.getRequiredSkillScore(requirement.getName());
            if (score < requirement.getMinimum()) {
            	return 0.0;
            }
            sum += score * requirement.getMultiplier();
        }
        return sum;
    }

    public String summarizeApplications() {
        StringBuilder builder = new StringBuilder(this.name);
        builder.append(':');
        for(Application application : applications) {
            Applicant applicant = application.getApplicant();
            double score = application.getScore();
            String scoreText = score > 0.0 ? String.format("%.2f", score) : "did not meet requirements";
            builder.append(System.lineSeparator())
            	   .append('\t')
            	   .append(applicant.getName())
            	   .append(" - ")
            	   .append(scoreText);
        }

        return builder.toString();

    }

	public void addApplication(Applicant applicant) {
		this.applications.add(new Application(applicant, scoreFor(applicant)));
	}
	
	public Collection<Application> getApplications() {
		return this.applications;
	}
}