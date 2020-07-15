package hr.fer.oop.task1;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class User implements Searchable {

    private String name;
    private Date signupDate;
    private List<User> following;
    private List<Post> userPosts;
    private UserStatus userStatus;

    public User(String name) {
        this.name = name;
        this.signupDate = new Date(System.currentTimeMillis());

        this.userPosts = new ArrayList<Post>();
        this.following = new ArrayList<User>();

        this.userStatus = UserStatus.NOT_ACTIVATED;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return signupDate;
    }

    public List<Post> getPosts() {
        return userPosts;
    }

    public void addPost(Post userPost) {
    }

    public UserStatus getUserStatus() {
        return this.userStatus;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void addFollowing(User user) {
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    @Override
    public boolean searchHash(int hashCode) {
        // TODO Auto-generated method stub
        return false;
    }

}

enum UserStatus {
    NOT_ACTIVATED,
    ACTIVATED,
    DEACTIVATED
}
