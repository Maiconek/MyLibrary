package pl.edu.ug.mbaranowski.mylibrary.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.ug.mbaranowski.mylibrary.domain.Author;
import pl.edu.ug.mbaranowski.mylibrary.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("api/v1/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/all")
    public List<Author> getAllAuthors() {
        return authorService.allAuthors();
    }

    @GetMapping("/{id}")
    public Author getSingleAuthor(@PathVariable Long id) {
        return authorService.getSingleAuthor(id);
    }
}
