package treci;

public class Main {
	   public static void main(String[] args) {
		Set<Panda> family1 = new TreeSet<Panda>(Arrays.asList(new Panda("Sheng", 87), new Panda("Tai", 88)));
		Set<Panda> family2 = new TreeSet<Panda>(Arrays.asList(new Panda("Po", 102), new Panda("Tian", 99)));
		List<Set<Panda>> zoo = new LinkedList<Set<Panda>>();
		zoo.add(family1);
		zoo.add(family2);

		int i = 1;		
		for (Set<Panda> family : zoo) {
			for (Panda p: family) {
			  try(VirtualFood f = new VirtualFood(i)){
				try {
					p.eat(f);
				} catch (OverweightException e) {
					System.out.println(e.getMessage());
				}
			  }catch(Exception e) {
				  System.out.println(e.getMessage());
				  i=Integer.parseInt(e.getMessage());
			  }finally {
				  i++;
				  System.out.println(p.getName() + "... feeding finished.");
			  }
			}	
		}
		System.out.println("main - end");
	   }
	}

