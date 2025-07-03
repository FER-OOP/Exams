package hr.fer.oop;

public class Main {
    public static void main(String[] args) {
        TaskNotebook notebook = new TaskNotebook();
        
        System.out.println("--- Adding tasks ---");
        try {
            // Creating task instances with the new course names
            notebook.addTask(new Task("ITP", "Write the first homework for Introduction to Programming."));
            notebook.addTask(new Task("MATANA2", "Solve example problems for Mathematical Analysis 2."));
            notebook.addTask(new Task("OOP", "Prepare for the final Object-Oriented Programming exam."));
        } catch (DuplicateTaskException e) {
            System.err.println("Error while adding: " + e.getMessage());
        }

        notebook.printAllTasks();

        System.out.println("\n--- Attempting to add a duplicate task ---");
        try {
            // Attempting to add a task with the same ID
            notebook.addTask(new Task("OOP", "Review the course material for the exam."));
        } catch (DuplicateTaskException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        System.out.println("\n--- Completing tasks ---");
        try {
            // Marking tasks as completed
            notebook.completeTask("ITP");
            notebook.completeTask("MATANA2");
        } catch (TaskNotFoundException | TaskAlreadyCompletedException e) {
            System.err.println("Error while completing: " + e.getMessage());
        }

        notebook.printAllTasks();

        System.out.println("\n--- Attempting to complete an already completed task ---");
        try {
            // Attempting to complete the same task again
            notebook.completeTask("ITP");
        } catch (TaskNotFoundException | TaskAlreadyCompletedException e) {
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- Removing a task ---");
        try {
            // Removing a task from the notebook
            notebook.removeTask("OOP");
            System.out.println("Task 'OOP' was successfully removed.");
            
            notebook.removeTask("MATANA3"); // Attempting to remove a non-existing task
            System.out.println("Task 'MATANA3' was successfully removed."); // This line will not execute
        } catch (TaskNotFoundException e) {
            System.err.println("Error while removing: " + e.getMessage());
        }

        System.out.println("\n--- Final state of the notebook ---");
        notebook.printAllTasks();
    }
}