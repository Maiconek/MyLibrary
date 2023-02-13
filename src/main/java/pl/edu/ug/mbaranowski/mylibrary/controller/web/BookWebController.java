package pl.edu.ug.mbaranowski.mylibrary.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.ug.mbaranowski.mylibrary.domain.Book;
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

    @GetMapping("/books/info/{id}")
    public String bookInfo(Model model, @PathVariable Long id) {
        model.addAttribute("book", bookService.getSingleBook(id));
        return "books-info";
    }

    @GetMapping("/books/add")
    public String bookAdding(Model model) {
        model.addAttribute("bookToAdd", new Book());
        return "books-add";
    }

    @PostMapping("/books/all")
    public String addNewBook(Model model, @ModelAttribute Book bookToAdd) {
        bookService.addBook(bookToAdd);
        model.addAttribute("allBooks", bookService.allBooks());
        return "books";
    }

    @GetMapping("/books/edit/{id}")
    public String bookUpdating(Model model, @PathVariable Long id) {
        model.addAttribute("bookToEdit", bookService.getSingleBook(id));
        return "books-edit";
    }

    @PostMapping("/books/edited/{id}")
    public String updateBook(Model model, @ModelAttribute Book bookToEdit, @PathVariable Long id) {
        bookService.editBook(id, bookToEdit);
        String info = "Book was successfully updated";
        model.addAttribute("updated", info);
        return "books-edited";
    }

    @GetMapping("/books/deleted/{id}")
    public String deleteBook(Model model, @PathVariable Long id) {
        model.addAttribute("title", bookService.getSingleBook(id).getTitle());
        bookService.deleteBookFromDB(id);
        return "books-deleted";
    }


}
