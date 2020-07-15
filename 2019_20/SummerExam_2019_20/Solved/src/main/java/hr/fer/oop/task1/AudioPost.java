package hr.fer.oop.task1;

public class AudioPost extends Post {

    private byte[] audioData;
    private String description;

    public AudioPost(User author, byte[] audioData, String description) {
        super(author);

        this.audioData = audioData.clone();
        this.description = description;
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
