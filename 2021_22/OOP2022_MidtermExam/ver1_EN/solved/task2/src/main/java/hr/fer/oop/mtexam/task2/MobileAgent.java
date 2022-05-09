package hr.fer.oop.mtexam.task2;

class MobileAgent extends Agent implements Movable {
	private int taskId;

	public MobileAgent(String name, int ID) {
		super(name, ID);
		doRemoteTask();
	}

	public int getTaskId() {
		return taskId;
	}

	@Override
	public String getAgentType() {
		return "mobile agent";
	}

	@Override
	public void doRemoteTask() {
	    taskId = (int) ((Math.random() * 10) + 1);
	}
}
