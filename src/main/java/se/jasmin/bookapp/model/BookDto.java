package se.jasmin.bookapp.model;

public class BookDto {

    private String title;
    private String authorId;

    public BookDto() {
    }

    public BookDto(String title, String authorId) {
        this.title = title;
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
}


