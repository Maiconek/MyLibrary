package pl.edu.ug.mbaranowski.mylibrary.service;

import org.springframework.stereotype.Service;
import pl.edu.ug.mbaranowski.mylibrary.domain.Book;
import pl.edu.ug.mbaranowski.mylibrary.repository.BookRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> allBooks() {
        return bookRepository.getAllBooks();
    }

    public Book getSingleBook(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("book does not exist"));
    }

    public Book addBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    public Book editBook(Long id, Book book) {
        return bookRepository.findById(id)
                .map(element -> {
                    element.setTitle(book.getTitle());
                    element.setYearOfPublication(book.getYearOfPublication());
                    return bookRepository.save(element);
                }).orElseGet(() -> {
                    book.setId(id);
                    return bookRepository.save(book);
                });
    }

    public boolean deleteBookFromDB(Long id) {
        List<Book> bookList = bookRepository.getAllBooks();
        for(Book b : bookList) {
            if(Objects.equals(b.getId(), id)) {
                bookRepository.delete(b);
                return true;
            }
        }
        return false;
    }
}
