package se.jasmin.bookapp.model;

public class CreateNewBookDto {

    private String title;
    private String authorId;
    private String categoryId;
    private String description;
    private String year;

    public CreateNewBookDto() {
    }

    public CreateNewBookDto(String title, String authorId, String categoryId, String description, String year) {
        this.title = title;
        this.authorId = authorId;
        this.categoryId = categoryId;
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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
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

    @Override
    public String toString() {
        return "CreateNewBookDto{" +
                "title='" + title + '\'' +
                ", authorId='" + authorId + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", description='" + description + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

}






