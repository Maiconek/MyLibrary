package pl.edu.ug.mbaranowski.mylibrary.controller.api;

import org.springframework.web.bind.annotation.*;
import pl.edu.ug.mbaranowski.mylibrary.domain.Book;
import pl.edu.ug.mbaranowski.mylibrary.service.BookService;

import java.util.List;

@RestController
@RequestMapping("api/v1/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    List<Book> allBooks() {
        return bookService.allBooks();
    }

    @GetMapping("/{id}")
    Book singleBook(@PathVariable Long id) {
        return bookService.getSingleBook(id);
    }

    @PostMapping
    Book addNewBook(@RequestBody Book book) {
        bookService.addBook(book);
        return book;
    }

    @PutMapping("/{id}")
    Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.editBook(id, book);
    }

    @DeleteMapping("/{id}")
    boolean deleteBook(@PathVariable Long id) {
        return bookService.deleteBookFromDB(id);
    }
}
