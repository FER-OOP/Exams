package hr.fer.oop.genomeseq;

public class MySeqList <T extends Sequence> extends MyList <T> {
	
	public MySeqList() {
		super();
	}
	
	public void addall(MySeqList<? extends T> anotherlist) {
		for (int i=0; i<anotherlist.size(); i++) {
			T elem = anotherlist.get(i);
			this.add(elem);
		}
	}	
}
