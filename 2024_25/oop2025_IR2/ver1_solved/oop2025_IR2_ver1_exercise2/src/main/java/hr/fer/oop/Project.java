package hr.fer.oop;

public class Project {
    private final String id;
    private final String description;
    private final ProjectPriority priority;
    private boolean done;

    public Project(String id, String description, ProjectPriority priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.done = false;
    }

    public void markAsDone() throws ProjectAlreadyCompletedException {
        if (done) {
            throw new ProjectAlreadyCompletedException("Project with identifier '" + id + "' is already marked as done.");
        }
        this.done = true;
    }

    public boolean isDone() {
        return done;
    }

    public String getId() {
        return id;
    }

    public ProjectPriority getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        String status = done ? "[X]" : "[ ]";
        return status + " (" + priority + ") " + id + ": " + description;
    }
}