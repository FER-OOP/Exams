package hr.fer.oop.task1;

import java.util.Objects;

public class WorkerTool<T extends Tool> {
	private T toolType;
	private String description;
	
	public WorkerTool(T toolType, String description) {
		this.toolType = toolType;
		this.description = description;
		
	}
	
	public T getToolType() {
		return toolType;
	}

	public String getDescription() {
		return description;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		
		if (obj instanceof WorkerTool) {
			WorkerTool t = (WorkerTool) obj;
			return getDescription().equals(t.getDescription())
					&&
				  getToolType().equals(t.getToolType());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getDescription(),getToolType());
	}

	
	
}
