package drugi;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PlasmanExplorer {
	List<Plasman> listaPlasmana=new ArrayList<Plasman>();
	
	public void printPobjednike()
	{
		listaPlasmana.stream()
			.filter(x-> x.getGodina()>2000)
			.collect(Collectors.groupingBy(Plasman::getVozac, 
						 Collectors.minBy(Comparator.comparingInt(Plasman::getPlasman))))
			.entrySet().stream()
			.filter(x-> x.getValue().get().getPlasman()==1)
			.map(x->x.getKey())
			.sorted()
			.forEach(System.out::println);

	}
	
	public void loadPlasmani(String filepath) {
		
		BufferedReader br;
		try{
		br=new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(filepath)),"UTF-8"));
		String strLine;
		while((strLine=br.readLine())!=null){
		String[]inputData=strLine.split(";");
		listaPlasmana.add(new Plasman(Integer.parseInt(inputData[0]),Integer.parseInt(inputData[1]),inputData[2],Integer.parseInt(inputData[3])));
		}
		}catch(Exception ex ){
		System.err.println(ex);
		}
	}
	
	public PlasmanExplorer(String filepath) {
	loadPlasmani(filepath);
	
	}
	
	public static void main(String[] args) {
		PlasmanExplorer xpl=new PlasmanExplorer("F1.csv");
		xpl.printPobjednike();
	}

}
