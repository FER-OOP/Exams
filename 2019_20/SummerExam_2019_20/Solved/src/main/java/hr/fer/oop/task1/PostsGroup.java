package hr.fer.oop.task1;

import java.util.List;

public class PostsGroup<T extends Post> extends Post {

    private List<T> postsToHighlight;

    public PostsGroup(User author) {
        super(author);
        // TODO Auto-generated constructor stub
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    @Override
    public void displayPost() {
        // TODO Auto-generated method stub

    }

}
