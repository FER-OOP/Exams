package hr.fer.oop.task1;

public class TextPost extends Post {

    private String text;

    public TextPost(User author, String text) {
        super(author);
        this.text = text;
    }

    @Override
    public void displayPost() {
        // TODO Auto-generated method stub

    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

}
