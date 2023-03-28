package pl.edu.ug.mbaranowski.mylibrary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.edu.ug.mbaranowski.mylibrary.domain.Author;
import pl.edu.ug.mbaranowski.mylibrary.domain.Book;
import pl.edu.ug.mbaranowski.mylibrary.repository.AuthorRepository;
import pl.edu.ug.mbaranowski.mylibrary.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MylibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MylibraryApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(BookRepository bookRepository, AuthorRepository authorRepository) {
		return args -> {
			Book book = new Book("Hunger Games", 2008);
			Book book2 = new Book("Szybko, Szybciej, Najszybciej", 2022);
			Author author = new Author("Suzanne", "Collins", 1962, "US");
			Author author2 = new Author("Mikołaj", "Sokół", 1979, "Poland");

			System.out.println("Inserting data...");

			authorRepository.save(author);
			authorRepository.save(author2);

			List<Author> authorsList = new ArrayList<>();
			authorsList.add(author);

			book.setAuthors(authorsList);
			bookRepository.save(book);

			authorsList.set(0, author2);
			book2.setAuthors(authorsList);
			bookRepository.save(book2);




		};
	}

}
