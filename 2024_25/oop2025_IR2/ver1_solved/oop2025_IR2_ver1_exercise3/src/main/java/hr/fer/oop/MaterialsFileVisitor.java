package hr.fer.oop;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class MaterialsFileVisitor extends SimpleFileVisitor<Path>{

	private List<Material> mlist;
	
	public MaterialsFileVisitor() {
		mlist = new ArrayList<Material>();
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if (file.toString().endsWith(".zip")) {
			ZipFile zipFile = new ZipFile(file.toString());
			zipFile.stream().forEach(entry -> {
				String ext = entry.getName().substring(entry.getName().lastIndexOf(".")+1);
				Material m = new Material(entry.getName(), ext, entry.getSize(), entry.getCompressedSize(), file.getFileName().toString());
				mlist.add(m);
			});
		}
			
		return FileVisitResult.CONTINUE;
	}
	
	public int getTotalMaterialCount() {
		return mlist.size();
	}
	
	public String getBiggestFileName() {
		return mlist.stream()
					.max((m1,m2)->Long.compare(m1.uncompressedSize,m2.uncompressedSize))
					.get()
					.materialFileName;
	}
	
	public long getPdfCount(String zipFileName) {
		return mlist.stream()
				.filter(m -> m.zipFileName.equals(zipFileName))
				.filter(m -> m.materialFileExtension.equals("pdf"))
				.count();
	}
	
	public long getCourseMaterialUncompressedSize(String zipFileName) {
		return mlist.stream()
				.filter(m -> m.zipFileName.equals(zipFileName))
				.mapToLong(m -> m.uncompressedSize)
				.sum();
	}
	
	public long getCourseMaterialCompressedSize(String zipFileName) {
		return mlist.stream()
				.filter(m -> m.zipFileName.equals(zipFileName))
				.mapToLong(m -> m.compressedSize)
				.sum();
	}
	
	public void print() {
		mlist.stream().forEach(m -> System.out.println(m));
	}
	
}
