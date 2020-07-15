package hr.fer.oop.task1;

import java.util.Date;

public abstract class Post implements Searchable {

    private Date lastModified;
    private PostStatus status;
    private User user;

    public abstract void displayPost();

    public Post(User author) {
        this.user = author;
        this.status = PostStatus.DRAFT;
        this.lastModified = new Date(System.currentTimeMillis());
    }

    public User getAuthor() {
        return user;
    }

    public PostStatus getStatus() {
        return status;
    }

    public void setStatus(PostStatus postStatus) {
        this.status = postStatus;
    }

    public Date getLastModifiedAt() {
        return lastModified;
    }

    public boolean searchHash(int hashCode) {
        return false;
    }
}

enum PostStatus {
    DRAFT,
    HIDDEN,
    PUBLISHED
}
