package se.jasmin.bookapp.modelEntity;

import javax.persistence.*;


@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private Author author;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "YEAR")
    private String year;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", description='" + description + '\'' +
                ", year='" + year + '\'' +
                ", category=" + category +
                '}';
    }
}
