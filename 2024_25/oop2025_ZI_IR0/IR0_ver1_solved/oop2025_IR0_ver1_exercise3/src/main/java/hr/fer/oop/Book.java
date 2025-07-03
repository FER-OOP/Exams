package hr.fer.oop;

public class Book extends Content<String> {
    public Book(String id, String title, String data) {
        super(id, title, data);
    }

    @Override
    public String describeContent() {
		if (getData() == null || getData().isEmpty()) {
			return "";
		}
		
		if (getData().length() <= 30) {
			return "Content: " + getData();
		}
		else {
			return "Content: " + getData().substring(0, 30) + "...";
		}
    }
}
