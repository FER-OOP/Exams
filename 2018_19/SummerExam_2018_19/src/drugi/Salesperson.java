package drugi;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import prvi.Barcoded;
import prvi.Item;
import prvi.Pack;

public class Salesperson {
	   // TO DO: napišite metodu tako da koristite kolekcijske streamove
	   public void printItems(List<Item> list, Predicate <Item> p) {
			list.stream()
			.filter(p)
			.sorted((i1, i2)->i1.getName().compareTo(i2.getName()))
			.forEach(i->System.out.println(i));
	  } 	
	   // TO DO: dopunite zaglavlje metode
	   public void printTheBill(Item [] basket){
	   //public void printTheBill(Item ... basket){	// OK
	  	double total = 0.;
		for(Item i: basket){
	       // TO DO: napišite metodu tako da ispis odgovara prikazanom 
	   	  if(i instanceof Pack)
			System.out.format("%s %dx%.2f\n%-30s%6.2f\n", i.getName(), 
			((Pack) i).getItemsInPack().length, 
			((Pack) i).getItemsInPack()[0].getSalePrice(), "", i.getSalePrice() );
		  else
			System.out.format("%-30s%6.2f\n", i.getName(), i.getSalePrice());
		  total += i.getSalePrice();		
		}
		System.out.format("%30s%6.2f\n", "TOTAL: ", total);
	  }
	  // TO DO: dopunite zaglavlje metode
	  public Map<String, OriginOfProduct> getOrigin(List<? extends Barcoded> list) {
		// TO DO: napišite metodu
		Map<String, OriginOfProduct> origins = new LinkedHashMap<>();
		for(Barcoded b: list){
			if(b.barcode().startsWith("385"))
				 origins.put(b.barcode(), OriginOfProduct.DOMESTIC);
			else
				origins.put(b.barcode(), OriginOfProduct.FOREIGN);
		}			
		return origins;	
	  }	
	}
