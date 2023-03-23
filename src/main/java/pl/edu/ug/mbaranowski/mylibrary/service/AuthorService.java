package pl.edu.ug.mbaranowski.mylibrary.service;

import org.springframework.stereotype.Service;
import pl.edu.ug.mbaranowski.mylibrary.domain.Author;
import pl.edu.ug.mbaranowski.mylibrary.repository.AuthorRepository;

import java.util.List;

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
}
