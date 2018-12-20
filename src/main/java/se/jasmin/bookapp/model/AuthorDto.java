package se.jasmin.bookapp.model;

public class AuthorDto {

    private String name;
    private String aboutAuthor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAboutAuthor() {
        return aboutAuthor;
    }


    public void setAboutAuthor(String aboutAuthor) {
        this.aboutAuthor = aboutAuthor;


    }

    @Override
    public String toString() {
        return "AuthorDto{" +
                "name='" + name + '\'' +
                ", aboutAuthor='" + aboutAuthor + '\'' +
                '}';
    }
}
