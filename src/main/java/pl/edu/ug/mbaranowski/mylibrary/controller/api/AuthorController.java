package pl.edu.ug.mbaranowski.mylibrary.controller.api;

import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/add")
    public Author addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    @PutMapping("/edit/{id}")
    public Author editAuthor(@RequestBody Author author, @PathVariable Long id) {
        return authorService.editAuthor(id, author);
    }

    @DeleteMapping("/{id}")
    public boolean deleteAuthor(@PathVariable Long id) {
        return authorService.deleteAuthor(id);
    }
}
