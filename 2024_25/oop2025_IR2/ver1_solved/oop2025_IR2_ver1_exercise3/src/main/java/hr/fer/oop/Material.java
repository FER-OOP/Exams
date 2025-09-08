package hr.fer.oop;

public class Material {
	
	public String materialFileName;
	public String materialFileExtension;
	public long uncompressedSize;
	public long compressedSize;
	public String zipFileName;
	
	public Material(String materialFileName, String materialFileExtension, long uncompressedSize, long compressedSize, String zipFileName) {
		this.materialFileName = materialFileName;
		this.materialFileExtension = materialFileExtension;
		this.uncompressedSize = uncompressedSize;
		this.compressedSize = compressedSize;
		this.zipFileName = zipFileName;
	} 

	public String toString() {
		return this.materialFileName + " " +
				materialFileExtension + " " +
				uncompressedSize + " " +
				compressedSize + " " +
				zipFileName;
	}
	
}
