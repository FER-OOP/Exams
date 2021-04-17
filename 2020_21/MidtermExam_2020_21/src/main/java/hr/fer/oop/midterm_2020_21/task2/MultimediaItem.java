package hr.fer.oop.midterm_2020_21.task2;

public abstract class MultimediaItem {

    private String title;    

    public MultimediaItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }   

    public abstract byte[] getIcon();        
}
