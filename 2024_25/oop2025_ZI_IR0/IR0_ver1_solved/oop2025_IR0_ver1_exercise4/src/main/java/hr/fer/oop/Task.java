package hr.fer.oop;

//Class representing the task
public class Task {
	private final String id;
	private final String description;
	private boolean done;
	
	public Task(String id, String description) {
		this.id = id;
		this.description = description;
		this.done = false;
	}
	
	public void markAsDone() throws TaskAlreadyCompletedException {
		if (done) {
			throw new TaskAlreadyCompletedException("Task with identifier '" + id + "' is already marked as done.");
	    }
	    this.done = true;
	}
	
	public boolean isDone() {
		return done;
	}
	
	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		String status = done ? "[X]" : "[ ]";
		return status + " " + id + ": " + description;
	}
}
