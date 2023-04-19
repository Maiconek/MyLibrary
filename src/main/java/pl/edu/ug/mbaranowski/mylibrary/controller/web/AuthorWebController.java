package pl.edu.ug.mbaranowski.mylibrary.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.edu.ug.mbaranowski.mylibrary.domain.Author;
import pl.edu.ug.mbaranowski.mylibrary.service.AuthorService;

import java.util.List;

@Controller
public class AuthorWebController {
    private final AuthorService authorService;

    public AuthorWebController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors/all")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorService.allAuthors());
        return "authors";
    }

    @GetMapping("/authors/info/{id}")
    public String getSingleAuthor(@PathVariable Long id, Model model) {
        model.addAttribute("author", authorService.getSingleAuthor(id));
        return "";
    }
}
