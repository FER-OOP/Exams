package hr.fer.oop;

import java.util.*;

public class TaskNotebook {
    private final Map<String, Task> tasks = new TreeMap<>();

    public void addTask(Task task) throws DuplicateTaskException {
        if (tasks.containsKey(task.getId())) {
            throw new DuplicateTaskException("Task with identifier '" + task.getId() + "' already exists.");
        }
        tasks.put(task.getId(), task);
    }

    public void removeTask(String id) throws TaskNotFoundException {
        if (!tasks.containsKey(id)) {
            throw new TaskNotFoundException("Task with identifier '" + id + "' does not exist.");
        }
        tasks.remove(id);
    }

    public void completeTask(String id) throws TaskNotFoundException, TaskAlreadyCompletedException {
        Task task = tasks.get(id);
        if (task == null) {
            throw new TaskNotFoundException("Task with identifier '" + id + "' does not exist.");
        }
        task.markAsDone();
    }

    public void printAllTasks() {
        for (Task task : tasks.values()) {
            System.out.println(task);
        }
    }
}
