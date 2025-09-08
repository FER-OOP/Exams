package hr.fer.oop;

public class Main {
    public static void main(String[] args) {
        ProjectManager manager = new ProjectManager();

        System.out.println("--- 1. Adding initial projects ---");
        try {
			manager.addProject(new Project("WEB-APP", "Development of a new web application for a client.", ProjectPriority.NORMAL));
            manager.addProject(new Project("MOBILE-GAME", "Creation of a mobile game for Android and iOS.", ProjectPriority.LOW));
            manager.addProject(new Project("AI-RESEARCH", "Researching new AI models for language processing.", ProjectPriority.HIGH));
        } catch (ProjectException e) {
            System.err.println("Error during initialization: " + e.getMessage());
        }
        manager.printAllProjects();

        System.out.println("\n--- 2. Attempting to add a project with a duplicate ID ---");
        try {
            manager.addProject(new Project("WEB-APP", "Upgrading the existing web application.", ProjectPriority.NORMAL));
        } catch (ProjectException e) {
            System.err.println("Expected error: " + e.getMessage());
        }

        System.out.println("\n--- 3. Marking a project as complete ---");
        try {
            manager.completeProject("MOBILE-GAME");
        } catch (ProjectException e) {
            System.err.println("Error: " + e.getMessage());
        }
        System.out.println("State after completing a project:");
        manager.printAllProjects();

        System.out.println("\n--- 4. Attempting to remove a non-existent project ---");
        try {
            manager.removeProject("DATA-ANALYSIS");
        } catch (ProjectException e) {
            System.err.println("Expected error: " + e.getMessage());
        }

        System.out.println("\n--- 5. Final state of the project portfolio ---");
        manager.printAllProjects();
    }
}
