package pl.edu.ug.mbaranowski.mylibrary.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.*;
import java.util.List;

@Entity

public class Book {
    private Long id;
    private String title;

    @NotNull(message = "Year of publication must be before 2023 and no sooner than 1000")
    @Min(value = 1000)
    @Max(value = 2023)
    private Integer yearOfPublication;

    private List<Author> authors;

    public Book() {
    }

    public Book(String title, Integer yearOfPublication) {
        this.title = title;
        this.yearOfPublication = yearOfPublication;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToMany
    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }


    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", authors=" + authors +
                '}';
    }
}
