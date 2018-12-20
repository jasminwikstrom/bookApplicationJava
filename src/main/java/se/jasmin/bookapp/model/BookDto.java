package se.jasmin.bookapp.model;

public class BookDto {

    private String title;
    private String authorId;
    private String description;
    private String year;



    public BookDto() {
    }

    public BookDto(String title, String authorId, String description)  {
        this.title = title;
        this.authorId = authorId;
        this.description = description;
        this.year = year;
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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


}


