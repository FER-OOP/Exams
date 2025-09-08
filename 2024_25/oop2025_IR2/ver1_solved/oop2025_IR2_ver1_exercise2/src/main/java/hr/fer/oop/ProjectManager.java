package hr.fer.oop;

import java.util.*;

public class ProjectManager {
    private final Map<String, Project> projects = new TreeMap<>();

    public void addProject(Project project) throws DuplicateProjectException {
        if (projects.containsKey(project.getId())) {
            throw new DuplicateProjectException("Project with id '" + project.getId() + "' already exists.");
        }
        projects.put(project.getId(), project);
    }

    public void removeProject(String id) throws ProjectNotFoundException {
        if (!projects.containsKey(id)) {
            throw new ProjectNotFoundException("Project with id '" + id + "' does not exist.");
        }
        projects.remove(id);
    }

    public void completeProject(String id) throws ProjectNotFoundException, ProjectAlreadyCompletedException {
        Project project = projects.get(id);
        if (project == null) {
            throw new ProjectNotFoundException("Project with id '" + id + "' does not exist.");
        }
        project.markAsDone();
    }

    public void printAllProjects() {
        for (Project project : projects.values()) {
            System.out.println(project);
        }
    }
}