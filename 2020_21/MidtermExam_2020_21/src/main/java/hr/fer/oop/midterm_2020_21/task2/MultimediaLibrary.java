package hr.fer.oop.midterm_2020_21.task2;

public class MultimediaLibrary {

    private final MultimediaItem[] multimediaItems;
    private int count;

    public MultimediaLibrary(int size) {
		this.multimediaItems = new MultimediaItem[size];
		count = 0;
	}

	public int count() {
		return count;
	}
	
	public MultimediaItem itemAt(int pos) {
		return null; //TO DO: Finish for practice
	}

	public void addItem(MultimediaItem multimediaItem) {
		 //TO DO: Finish for practice
    }

	public void removeItems(MultimediaItem[] multimediaItems) {
		 //TO DO: Finish for practice
	}

}
