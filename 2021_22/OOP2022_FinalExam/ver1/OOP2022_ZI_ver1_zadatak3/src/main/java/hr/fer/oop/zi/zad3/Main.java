package hr.fer.oop.zi.zad3;


public class Main {

    public static Position getSeniorDevPosition() {
        Position seniorDev = new Position("Senior backend developer");
        RequiredSkill javaReq = new RequiredSkill("Java", 5, 10);
        RequiredSkill sqlReq = new RequiredSkill("SQL", 3, 10);

        seniorDev.addRequiredSkill(javaReq)
                .addRequiredSkill(sqlReq);
        return seniorDev;
    }

    public static Position getEmbeddedDevPosition() {
        Position embeddedDev = new Position("Mid embedded developer");
        RequiredSkill cReq = new RequiredSkill("C", 3, 15);
        RequiredSkill embJavaReq = new RequiredSkill("Java", 0, 4);
        embeddedDev.addRequiredSkill(cReq).addRequiredSkill(embJavaReq);
        return embeddedDev;
    }

    public static void runExample() {
        Position seniorDev = getSeniorDevPosition();
        Position embeddedDev = getEmbeddedDevPosition();

        Applicant mirko = new Applicant(0, "Mirko")
                .addRequiredSkillScore("Java", 5.0)
                .addRequiredSkillScore("C#", 7.0)
                .addRequiredSkillScore("SQL", 8.0);

        Applicant zdravko = new Applicant(1, "Zdravko")
                .addRequiredSkillScore("SQL", 3.0)
                .addRequiredSkillScore("C", 3.0);
        Applicant maja = new Applicant(2, "Maja")
                .addRequiredSkillScore("C", 5.5)
                .addRequiredSkillScore("Python", 2.5)
                .addRequiredSkillScore("Java", 6.0)
                .addRequiredSkillScore("SQL", 3.5);

        mirko.applyFor(seniorDev);
        zdravko.applyFor(seniorDev);
        maja.applyFor(seniorDev);

        maja.applyFor(embeddedDev);
        zdravko.applyFor(embeddedDev);

        System.out.println(seniorDev.summarizeApplications());
        System.out.println("");
        System.out.println(embeddedDev.summarizeApplications());
    }

    public static void main(String[] args) {

        runExample();

    }
}
