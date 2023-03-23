package pl.edu.ug.mbaranowski.mylibrary.service;

import org.springframework.stereotype.Service;
import pl.edu.ug.mbaranowski.mylibrary.domain.Author;
import pl.edu.ug.mbaranowski.mylibrary.repository.AuthorRepository;

import java.util.List;
import java.util.Objects;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> allAuthors() {
        return authorRepository.getAllAuthors();
    }

    public Author getSingleAuthor(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("author does not exist"));
    }

    public Author addAuthor(Author author) {
        authorRepository.save(author);
        return author;
    }

    public Author editAuthor(Long id, Author author) {
        return authorRepository.findById(id)
                .map(element -> {
                    element.setFirstName(author.getFirstName());
                    element.setLastName(author.getLastName());
                    element.setYearOfBirth(author.getYearOfBirth());
                    element.setNationality(author.getNationality());
                    return authorRepository.save(element);
                }).orElseGet(() -> {
                    author.setId(id);
                    return authorRepository.save(author);
                });
    }

    public boolean deleteAuthor(Long id) {
        List<Author> authorList = authorRepository.getAllAuthors();
        for(Author a : authorList) {
            if(Objects.equals(id, a.getId())) {
                authorRepository.delete(a);
                return true;
            }
        }
        return false;
    }
}
