package hr.fer.oop.t5;

public abstract class SpecialContainer extends Container {

	private String containerMaterial;
	
	public SpecialContainer(String id, int volume, String containerMaterial) {
		super(id, volume);
		this.containerMaterial = containerMaterial;
	}

	public String getContainerMaterial() {
		return containerMaterial;
	}

	public void setContainerMaterial(String containerMaterial) {
		this.containerMaterial = containerMaterial;
	}
	
}
