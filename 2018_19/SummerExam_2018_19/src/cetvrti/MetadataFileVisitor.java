package cetvrti;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class MetadataFileVisitor extends SimpleFileVisitor<Path> {

    private List<String> data = new LinkedList<>();
    public List<String> getMetaData() {return data;} //dohvaćanje liste
    private String fileExtension;
    public MetadataFileVisitor(String fileExtension) {
    	this.fileExtension = fileExtension;
    }
// TO DO: nadjačavanjem definirajte potrebne metode FileVisitora
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attr)
            throws IOException {
    	 fillList(dir, attr);
        return FileVisitResult.CONTINUE;
    }
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
    	if(fileExtension.equals("*")) { 
    		fillList(file, attr);
    		return FileVisitResult.CONTINUE;
    	}
    	
    	String fileName = file.getFileName().toString();
    	String extension="";
    	int i = fileName.lastIndexOf('.');
    	if (i > 0) 
    		extension = fileName.substring(i+1).toUpperCase();		
    	 	
    	if(extension.equals(fileExtension.toUpperCase()))
    		fillList(file, attr);		
    	return FileVisitResult.CONTINUE;
    }
    
    private void fillList(Path file, BasicFileAttributes attr) {
    	 StringBuilder sb = new StringBuilder();
	 //TO DO: napisati funkciju za pretvorbu formata vremena
    	 Function<String, String> f = new Function<String, String>(){
				@Override public String apply(String s) {
					return s.substring(0, 10) + " " + s.substring(11, 16);
				} 	 
         };

	 //TO DO napisati ostatak metode u kojem se priprema string za spremanje u listu
         sb.append(file.getFileName().toString()+",");   
         
        String timeStr = attr.creationTime().toString();
        sb.append(f.apply(timeStr)+",");
         
        if (!attr.isDirectory()) {
        	 sb.append(String.valueOf(attr.size()));
        } else
        	 sb.append(0);
        
         data.add(sb.toString());
    }	
}

