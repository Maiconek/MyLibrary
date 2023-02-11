package pl.edu.ug.mbaranowski.mylibrary.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.ug.mbaranowski.mylibrary.service.BookService;

@Controller
public class BookWebController {
    private final BookService bookService;

    public BookWebController(@Autowired  BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/all")
    public String allBooks(Model model) {
        model.addAttribute("allBooks", bookService.allBooks());
        return "books";
    }


}
