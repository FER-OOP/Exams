package hr.fer.oop.task1;

public class ImagePost extends Post {

    private byte[] imageData;

    public ImagePost(User author, byte[] imageData) {
        super(author);

        this.imageData = imageData.clone();
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
