package hr.fer.oop;

public abstract class Content<T> {
    private final String id;
    private final String title;
    private final T data;

    public Content(String id, String title, T data) {
        this.id = id;
        this.title = title;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public T getData() {
        return data;
    }

    public String getDescription() {
        return "[" + id + "] " + getTitle() + ": " + describeContent();
    }

    public abstract String describeContent();
}
